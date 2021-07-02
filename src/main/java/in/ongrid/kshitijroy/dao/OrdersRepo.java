package in.ongrid.kshitijroy.dao;

import in.ongrid.kshitijroy.model.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepo extends JpaRepository<Orders,Long> {
    List<Orders> findByUserOrderId(Long id);


}
