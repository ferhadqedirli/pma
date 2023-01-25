package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private final List<ProductMeasurement> measurements = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductGroup group;

    public void addMeasurement(ProductMeasurement measurement) {
        this.measurements.add(measurement);
    }

}
