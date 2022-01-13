package tsdv.basicspringbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsdv.basicspringbootweb.entity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
