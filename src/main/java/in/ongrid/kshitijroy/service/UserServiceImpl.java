package in.ongrid.kshitijroy.service;

import in.ongrid.kshitijroy.dao.*;
import in.ongrid.kshitijroy.model.dto.*;
import in.ongrid.kshitijroy.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    CartRepo cartRepo;

    @Autowired
    BookTitleRepo bookTitleRepo;

    @Autowired
    OrdersRepo ordersRepo;

    @Autowired
    BooksOrderedRepo booksOrderedRepo;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    AddressRepo addressRepo;



    @Override
    public void userSignUpService(UserSignUpRequestDTO userSignUpRequestDTO) {

        String email = userSignUpRequestDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null");
        }

        if(userSignUpRequestDTO.getPassword()==null || userSignUpRequestDTO.getPassword().isEmpty()){
            throw new IllegalArgumentException("Password cannot be null");
        }

        if(userSignUpRequestDTO.getPassword().length()<8){
            throw new IllegalArgumentException("Password should be more than 8 characters");
        }

        if(userSignUpRequestDTO.getAddressDTO().getPincode()==null){
            throw new IllegalArgumentException("Pincode cannot be null");
        }

        String pincode= userSignUpRequestDTO.getAddressDTO().getPincode();
        if(pincode.length()!=6 ){
            throw new IllegalArgumentException("Pincode must be be 6 digits");
        }

        String city= userSignUpRequestDTO.getAddressDTO().getCity();
        if(city==null || city.isEmpty()){
            throw new IllegalArgumentException("Enter correct city");
        }

        validateEmail(email);

        User user = userRepo.findByEmail(email);

        if (user != null) {
            throw new IllegalArgumentException("Email registered before");
        }

        Address address = new Address(userSignUpRequestDTO.getAddressDTO().getHouseDetail(),userSignUpRequestDTO.getAddressDTO().getCity(),
                userSignUpRequestDTO.getAddressDTO().getPincode());

         user = new User(userSignUpRequestDTO.getName(),userSignUpRequestDTO.getEmail(),
                userSignUpRequestDTO.getPassword(),address);
        userRepo.save(user);


    }



    @Override
    public UserSignInResponseDTO UserSignIn(UserSignInRequestDTO userSignInRequestDTO) {
        String email = userSignInRequestDTO.getEmail();
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email ID cannot be null");
        }

        if(userSignInRequestDTO.getPassword()==null || userSignInRequestDTO.getPassword().isEmpty()){
            throw new IllegalArgumentException("Password cannot be null");
        }

        validateEmail(email);

        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User has not signed-up");
        }

        String password = user.getPassword();
        if (!userSignInRequestDTO.getPassword().equals(password)) {
            throw new IllegalArgumentException("Email/password incorrect");
        }

        return new UserSignInResponseDTO(user.getId(),user.getName());

    }

    @Override
    public UserProfileResponseDTO viewProfile(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("User id cannot be null");
        }

        User user = userRepo.getById(id);
        if(user ==null){
            throw new IllegalArgumentException("User not found");
        }

        return new UserProfileResponseDTO(user.getId(),user.getName(),
                user.getEmail(),user.getAddress().getHouseDetail(),user.getAddress().getCity());

    }

    @Override
    public void updateProfile(UserProfileUpdateRequestDTO userProfileUpdateRequestDTO, Long id) {
        if(id==null){
            throw new IllegalArgumentException("User ID cannot be null");
        }

        User user = userRepo.getById(id);
        if(user==null){
            throw new IllegalArgumentException("User not found");
        }

        if(userProfileUpdateRequestDTO.getPincode().length()==0 || userProfileUpdateRequestDTO.getPincode()==null){
            throw new IllegalArgumentException("Pincode cannot be empty");
        }

        if(userProfileUpdateRequestDTO.getPincode().length()!=6){
            throw new IllegalArgumentException("Pincode must be 6 digits");
        }

        if(userProfileUpdateRequestDTO.getCity().length()==0 || userProfileUpdateRequestDTO.getCity()==null){
            throw new IllegalArgumentException("Enter a valid city");
        }

        Address address = user.getAddress();

        address.setCity(userProfileUpdateRequestDTO.getCity());
        address.setHouseDetail(userProfileUpdateRequestDTO.getHouseDetails());
        address.setPincode(userProfileUpdateRequestDTO.getPincode());
        addressRepo.save(address);

    }

    @Override
    public Integer cartInitialise(Long userId){
        if(userId==null){
            throw new IllegalArgumentException("User ID cannot be null");
        }

        Cart cart= cartRepo.findByUserCartIdAndPurchased(userId,false);
        if(cart!=null){
            return cart.getBookTitleList().size();
        }
        User user= userRepo.getById(userId);

        List<Cart> carts= cartRepo.findByUserCartId(userId);
        cart= new Cart();
        cart.setUserCart(user);
        cartRepo.save(cart);
        Long cartId= cart.getId();
        carts.add(cart);
        user.setuCart(carts);
        System.out.println(cartId);
        return cart.getBookTitleList().size();
    }

    @Override
    public CartAddResponseDTO addToCart(Long userId, CartAddRequestDTO cartAddRequestDTO) {

        if(userId==null){
            throw new IllegalArgumentException("User ID cannot be null");
        }

        Cart cart = cartRepo.findByUserCartIdAndPurchased(userId, false);

        if(cart==null){
            throw new IllegalArgumentException("User does not have an existing cart");
        }


        Long bookTitleId = cartAddRequestDTO.getBookTitleId();
        List<BookTitle> bookList = cart.getBookTitleList();
        BookTitle bookTitle = bookTitleRepo.getById(bookTitleId);
        bookList.add(bookTitle);
        cart.setBookTitleList(bookList);
       // cartRepo.save(cart);
        List<Cart> carts = new ArrayList<>();
        carts.add(cart);
        bookTitle.setCarts(carts);
        bookTitleRepo.save(bookTitle);

        CartAddResponseDTO cartAddResponseDTO = new CartAddResponseDTO();

        List<CartInfo> details = new ArrayList<>();
        for(BookTitle title : bookList){
            CartInfo cartInfo = new CartInfo(title.getId(), title.getBookName());
            details.add(cartInfo);
        }

        cartAddResponseDTO.setCartCount(bookList.size());
        cartAddResponseDTO.setBookTitleList(details);
        return cartAddResponseDTO;

    }

    @Override
    public Long issue(Long userId) {
        if(userId==null){
            throw new IllegalArgumentException("User ID cannot br null");
        }

        Cart cart= cartRepo.findByUserCartIdAndPurchased(userId,false);

        if(cart==null) {
            throw new IllegalArgumentException("no existing cart available");
        }

        List<BookTitle> bookTitleList =  cart.getBookTitleList();
        List<BooksOrdered> booksOrdered= new ArrayList<>();
        List<Long> bookTitlesId=new ArrayList<>();
        for (BookTitle bookTitle: bookTitleList){
            bookTitlesId.add(bookTitle.getId());
        }

        List<BookTitle> bookTitlesList= bookTitleRepo.findBooks(bookTitlesId);
        for(BookTitle bookTitle : bookTitlesList){
            BookTitle title = bookTitleRepo.getById(bookTitle.getId());
            title.setAvailable(title.getAvailable()-1);
            bookTitleRepo.save(title);
            Book book = bookRepo.getById(bookTitle.getBook().get(0).getId());
            book.setBooked(true);
            BooksOrdered booksOrder = new BooksOrdered();
            booksOrder.setBookBought(book);
            booksOrderedRepo.save(booksOrder);
            booksOrdered.add(booksOrder);
        }
        Orders orders= new Orders(new Date(), userRepo.getById(userId), booksOrdered );
        cart.setPurchased(true);
        ordersRepo.save(orders);
        cartRepo.save(cart);
        return orders.getId();
    }

    @Override
    public CartAddResponseDTO getCart(Long userId){
        if(userId==null){
            throw new IllegalArgumentException("User ID cannot be null");
        }

        Cart cart= cartRepo.findByUserCartIdAndPurchased(userId,false);
        List<BookTitle> bookTitleList= cart.getBookTitleList();

        CartAddResponseDTO cartAddResponseDTO=new CartAddResponseDTO();

        List<CartInfo> details = new ArrayList<>();
        for(BookTitle title : bookTitleList){
            CartInfo cartInfo = new CartInfo(title.getId(), title.getBookName());
            details.add(cartInfo);
        }

        cartAddResponseDTO.setCartCount(bookTitleList.size());
        cartAddResponseDTO.setBookTitleList(details);
        return cartAddResponseDTO;
    }


    @Override
    public List<ViewOrder>  viewOrder(Long userId){
        if(userId==null){
            throw new IllegalArgumentException("User ID cannot be null");
        }
        List<Orders> history= ordersRepo.findByUserOrderId(userId);
        List<ViewOrder> result= new ArrayList<>();

        for(Orders oldOrders: history){
            Long orderId= oldOrders.getId();
            Date issueDate= oldOrders.getIssueDate();
            Date returnDate=null;
            String bookName="";
            Long bookId=null ;
            List<BooksOrdered> booksOrderedList=oldOrders.getBooksOrderedList();
            for(BooksOrdered booksOrdered:booksOrderedList){
                bookId=booksOrdered.getBookBought().getId();// changed
                returnDate=booksOrdered.getReturnDate();
                Book bookDetail= bookRepo.getById(bookId);
                bookName=bookDetail.getName();
                ViewOrder oneOrder=new ViewOrder(bookId,bookName,issueDate,returnDate);
                result.add(oneOrder);
            }

        }

        return result;
    }


    @Override
     public  ReturnBookResponseDTO returnBook(Long userId,Long bookId){
        if (userId==null){
            throw new IllegalArgumentException("user id not valid");
        }
        if (bookId==null){
            throw new IllegalArgumentException("bookId not valid");
        }

        BooksOrdered booksOrdered= booksOrderedRepo.findByUserBookIdAndBookBoughtId(userId,bookId);
        Date returnDate= new Date();
        booksOrdered.setReturnDate(returnDate);
        booksOrderedRepo.save(booksOrdered);

        Date issueDate=booksOrdered.getOrdersInfo().getIssueDate();
        Long  timeDifference= returnDate.getTime()-issueDate.getTime();

        Long days_difference = (timeDifference / (1000*60*60*24));
        Long cost=0L;
        if (days_difference<=15){
            cost=days_difference*2;
        }
        else{
            cost=(days_difference-15)*5 + 30;
        }
        ReturnBookResponseDTO returnBookResponseDTO=new ReturnBookResponseDTO(bookId,returnDate,cost);

        Book book= bookRepo.getById(bookId);
        book.setBooked(false);
        bookRepo.save(book);

        BookTitle bookTitle=book.getBookTitle();
        bookTitle.setAvailable(bookTitle.getAvailable()+1);
        bookTitleRepo.save(bookTitle);


        return returnBookResponseDTO;

    }

    private void validateEmail(String email) {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Invalid Email-ID format");
        }
    }


}

