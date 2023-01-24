package az.personal.pma.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue
    private Long id;

    private Double quantity;

    @ManyToOne
    private ProductMeasurement productMeasurement;

    @OneToOne
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
