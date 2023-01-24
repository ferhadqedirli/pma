package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Warehouse {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Boolean negativeBalance;

    @ManyToOne
    @JsonIgnore
    private Branch branch;

    @OneToMany(mappedBy = "warehouse")
    private final List<ProductWarehouse> products = new ArrayList<>();

    public void addProduct(ProductWarehouse product) {
        this.products.add(product);
    }

    @PrePersist
    private void prePersist() {
        if (this.negativeBalance == null)
            this.negativeBalance = false;
    }
}
