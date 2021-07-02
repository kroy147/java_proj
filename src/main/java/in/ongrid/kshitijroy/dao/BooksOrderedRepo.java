package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.BooksOrdered;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksOrderedRepo extends JpaRepository<BooksOrdered,Long> {
   BooksOrdered findByUserBookIdAndBookBoughtId(Long userId,Long bookId);

}
