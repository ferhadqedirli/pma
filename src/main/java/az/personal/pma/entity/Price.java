package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Price implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(scale = 4)
    private Double price;

    @Column(nullable = false)
    private Integer priceType;

    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Measurement measurement;

}
