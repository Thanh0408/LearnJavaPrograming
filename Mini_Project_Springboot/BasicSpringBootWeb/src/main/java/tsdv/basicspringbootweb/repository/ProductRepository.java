package tsdv.basicspringbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsdv.basicspringbootweb.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
