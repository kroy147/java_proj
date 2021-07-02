package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.BookTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookTitleRepo extends JpaRepository<BookTitle,Long>{
  List<BookTitle> findByBookCategoryId(Long id);
  @Query(value = "select * from library.book_title as lb where lb.book_name LIKE %?1% ",nativeQuery = true)
  List<BookTitle> findByName(String bookName);

  @Query(value= "select bt.id,bt.available,b.id,b.booked from (select * from book_title where id \n " +
          "in (:bookTitleList)) as bt left join book as b on \n" +
          "bt.id=b.id where bt.available>=1 and b.booked=false;  ", nativeQuery = true)
   List<BookTitle> findBooks(List<Long> bookTitleList);


}
