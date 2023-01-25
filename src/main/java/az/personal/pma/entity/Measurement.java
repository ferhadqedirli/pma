package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Measurement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "measurement", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ProductMeasurement> products = new ArrayList<>();

    @OneToMany(mappedBy = "measurement", fetch = FetchType.LAZY)
    private List<Price> prices = new ArrayList<>();

    public void addPrice(Price price) {
        this.prices.add(price);
    }
}
