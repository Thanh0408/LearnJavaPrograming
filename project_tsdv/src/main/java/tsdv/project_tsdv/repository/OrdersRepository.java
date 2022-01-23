package tsdv.project_tsdv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsdv.project_tsdv.entity.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long> {
}
