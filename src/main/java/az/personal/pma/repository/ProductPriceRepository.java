package az.personal.pma.repository;

import az.personal.pma.entity.ProductPrice;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {
}
