package az.personal.pma.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @Column(unique = true, length = 13)
    private String barcode;

    @Column(nullable = false)
    private Integer productType;

    @OneToMany(mappedBy = "product")
    private final List<ProductMeasurement> measurements = new ArrayList<>();

    @ManyToOne
    private ProductGroup group;

    public void addMeasurement(ProductMeasurement measurement) {
        this.measurements.add(measurement);
    }

}
