package az.personal.pma.repository;

import az.personal.pma.entity.Measurement;
import az.personal.pma.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeasurementRepository extends JpaRepository<Measurement, Integer> {
}
