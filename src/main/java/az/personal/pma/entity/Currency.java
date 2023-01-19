package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String shortName;

    private String coinName;

    private String fullName;

    @Column(length = 3)
    private Integer code;

    @OneToMany(mappedBy = "currency")
    private final List<Exchange> exchanges = new ArrayList<>();

    @OneToMany(mappedBy = "currency")
    private final List<ProductPrice> prices = new ArrayList<>();

    public void addExchange(Exchange exchange) {
        this.exchanges.add(exchange);
    }

    public void removeExchange(Exchange exchange) {
        this.exchanges.remove(exchange);
    }

    public void addProductPrice(ProductPrice productPrice) {
        this.prices.add(productPrice);
    }

    public void removeProductPrice(ProductPrice productPrice) {
        this.prices.remove(productPrice);
    }
}
