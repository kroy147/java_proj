package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
   User findByEmail(String email);
}
