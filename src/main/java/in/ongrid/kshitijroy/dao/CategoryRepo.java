package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<BookCategory,Long> {

}
