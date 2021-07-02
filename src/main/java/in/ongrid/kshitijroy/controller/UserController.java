package in.ongrid.kshitijroy.controller;

import in.ongrid.kshitijroy.model.dto.*;
import in.ongrid.kshitijroy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @PostMapping("")
    public BaseResponse<Void> signUp(@RequestBody UserSignUpRequestDTO userSignUpRequestDTO){

         userService.userSignUpService(userSignUpRequestDTO);

      return  new BaseResponse<>(HttpStatus.OK.value(), "Success");
    }


    @PostMapping("/login")
    public BaseResponse <UserSignInResponseDTO> signIn(@RequestBody UserSignInRequestDTO userSignInRequestDTO){
        return new BaseResponse<>(HttpStatus.OK.value(),
                "Success", userService.UserSignIn(userSignInRequestDTO));
    }

    @GetMapping("/{id}")
    public BaseResponse<UserProfileResponseDTO> viewProfile(@PathVariable Long id){
        return new BaseResponse<>(HttpStatus.OK.value(), "Success", userService.viewProfile(id));
    }

    @PostMapping("/{id}")
   public BaseResponse<Void>  updateProfile(@RequestBody UserProfileUpdateRequestDTO userProfileUpdateRequestDTO,
                                @PathVariable Long id){

        userService.updateProfile(userProfileUpdateRequestDTO,id);
        return  new BaseResponse<>(HttpStatus.OK.value(), "Success");
    }

    @PostMapping("/{id}/cart/booktitle")
    public BaseResponse<CartAddResponseDTO> addInCart(@PathVariable Long id,
                                                      @RequestBody CartAddRequestDTO cartAddRequestDTO){
        return new BaseResponse<>(HttpStatus.OK.value(),
                "Success", userService.addToCart(id,cartAddRequestDTO));
    }

    @PostMapping("/{id}/cart/issue")
    public BaseResponse<Long> issueBook(@PathVariable Long id){
        return new BaseResponse<>(HttpStatus.OK.value(), "Success", userService.issue(id));
    }

    @GetMapping("/{id}/cart/booktitle")
    public BaseResponse<CartAddResponseDTO> getCart(@PathVariable Long id){
        return new BaseResponse<>(HttpStatus.OK.value(), "Success", userService.getCart(id));
    }

    @GetMapping("/{id}/order")
    public BaseResponse<List<ViewOrder>> viewOrders(@PathVariable Long id){
        return new BaseResponse<>(HttpStatus.OK.value(),"success",userService.viewOrder(id));
    }

    @PostMapping("/{id}/book/{id}/return")
    public BaseResponse<ReturnBookResponseDTO> returnBook(@PathVariable Long userId,@PathVariable Long bookId){
      return new BaseResponse<>(HttpStatus.OK.value(), "success",userService.returnBook(userId,bookId));
    }

    @PostMapping("/{id}/cart/initialise")
        public BaseResponse<Integer> cartInit(@PathVariable Long id){
            return new BaseResponse<>(HttpStatus.OK.value(), "success", userService.cartInitialise(id));
        }

   }



