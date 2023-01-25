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
public class Currency implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    private final List<Exchange> exchanges = new ArrayList<>();

    @OneToMany(mappedBy = "currency", fetch = FetchType.LAZY)
    @JsonIgnore
    private final List<Price> prices = new ArrayList<>();

    public void addExchange(Exchange exchange) {
        this.exchanges.add(exchange);
    }

    public void removeExchange(Exchange exchange) {
        this.exchanges.remove(exchange);
    }

    public void addProductPrice(Price price) {
        this.prices.add(price);
    }

    public void removeProductPrice(Price price) {
        this.prices.remove(price);
    }
}
