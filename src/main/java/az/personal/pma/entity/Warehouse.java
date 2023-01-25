package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    private String name;

    private Boolean negativeBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Branch branch;

    @OneToMany(mappedBy = "warehouse", fetch = FetchType.LAZY)
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
