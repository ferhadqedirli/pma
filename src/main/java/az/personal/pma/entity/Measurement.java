package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Measurement {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "measurement")
    @JsonIgnore
    private List<ProductMeasurement> products = new ArrayList<>();

    @OneToMany(mappedBy = "measurement")
    private List<Price> prices = new ArrayList<>();

    public void addPrice(Price price) {
        this.prices.add(price);
    }
}
