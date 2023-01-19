package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class ProductMeasurement {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Product product;

    @ManyToOne
    @JsonIgnore
    private Measurement measurement;

    @OneToMany(mappedBy = "productMeasurement")
    private List<ProductPrice> prices;

    public ProductMeasurement(Product product, Measurement measurement) {
        this.product = product;
        this.measurement = measurement;
    }

    public void addPrice(ProductPrice price) {
        this.prices.add(price);
    }

    public void removePrice(ProductPrice price) {
        this.prices.remove(price);
    }

}
