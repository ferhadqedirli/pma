package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product_recipe")
public class ProductRecipe {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Double productQuantity;

    @Column(nullable = false)
    private Double rawQuantity;
}
