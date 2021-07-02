package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Long> {
    List<Cart> findByUserCartId(Long userId);
    Cart findByUserCartIdAndPurchased(Long userId,boolean purchased);

}
