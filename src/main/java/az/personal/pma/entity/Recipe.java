package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Double quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private ProductMeasurement productMeasurement;

    @OneToOne(fetch = FetchType.LAZY)
    private Recipe recipe;

    public Recipe(ProductMeasurement productMeasurement, Double quantity) {
        this.productMeasurement = productMeasurement;
        this.quantity = quantity;
    }

    public Recipe(ProductMeasurement productMeasurement, Double quantity, Recipe recipe) {
        this.productMeasurement = productMeasurement;
        this.quantity = quantity;
        this.recipe = recipe;
    }
}
