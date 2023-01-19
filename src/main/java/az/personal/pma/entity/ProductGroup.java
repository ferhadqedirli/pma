package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class ProductGroup {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "group")
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }
}
