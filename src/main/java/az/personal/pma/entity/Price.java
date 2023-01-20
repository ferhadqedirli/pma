package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Price {
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
    @JsonIgnore
    private Measurement measurement;

}
