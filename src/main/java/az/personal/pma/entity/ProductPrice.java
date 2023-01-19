package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class ProductPrice {
    @Id
    @GeneratedValue
    private Long id;

    @Column(scale = 4)
    private Double price;

    @Column(nullable = false)
    private Integer priceType;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private ProductMeasurement productMeasurement;

}
