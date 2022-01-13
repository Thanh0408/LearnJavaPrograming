package tsdv.basicspringbootweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tsdv.basicspringbootweb.entity.ProductDetail;

public interface ProductDetailRepository extends JpaRepository<ProductDetail, Long> {
}
