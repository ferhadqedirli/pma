package az.personal.pma.repository;

import az.personal.pma.entity.ProductMeasurement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductMeasurementRepository extends JpaRepository<ProductMeasurement, Long> {
    ProductMeasurement findByProduct_IdAndMeasurement_Id(Long productId, Integer measurementId);
}
