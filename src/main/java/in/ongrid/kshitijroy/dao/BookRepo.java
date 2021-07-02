package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book,Long> {
}
