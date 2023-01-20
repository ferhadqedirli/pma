package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ProductMeasurement {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "measurement_id")
    private Measurement measurement;

    public ProductMeasurement(Product product, Measurement measurement) {
        this.product = product;
        this.measurement = measurement;
    }
}
