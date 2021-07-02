package in.ongrid.kshitijroy.service;

import in.ongrid.kshitijroy.dao.BookTitleRepo;
import in.ongrid.kshitijroy.model.dto.BookFilterResponseDTO;
import in.ongrid.kshitijroy.model.dto.BookTitleResponseDTO;
import in.ongrid.kshitijroy.model.entity.BookTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service
public class BookTitleServiceImpl implements BookTitleService {

  @Autowired
  BookTitleRepo bookTitleRepo;

  @Override
  public BookTitleResponseDTO getBookInfo(Long id){

      if(id==null){
          throw new IllegalArgumentException("BookTitle ID is invalid");

      }

     BookTitle bookTitle=bookTitleRepo.getById(id);

     BookTitleResponseDTO bookTitleResponseDTO=new BookTitleResponseDTO(bookTitle.getId(),bookTitle.getBookName(),
             bookTitle.getAuthorName(),bookTitle.getBookCover(),bookTitle.getAvailable(),
             bookTitle.getBookCategory().getName());

     return bookTitleResponseDTO;

  }

  @Override
    public BookFilterResponseDTO searchBook(Long id,String key){
      if(id==null && key.isEmpty()){
          throw new IllegalArgumentException("invalid argument");
      }
      List<BookTitle> bookTitleList;
       if(id==null){
           bookTitleList= bookTitleRepo.findByName(key);
       }
       else{
            bookTitleList=bookTitleRepo.findByBookCategoryId(id);
       }
       BookFilterResponseDTO bookFilterResponseDTO= new BookFilterResponseDTO(bookTitleList);
       return  bookFilterResponseDTO;
  }


}
