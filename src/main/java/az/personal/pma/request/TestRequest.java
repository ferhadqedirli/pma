package az.personal.pma.request;

import az.personal.pma.entity.Exchange;
import az.personal.pma.entity.Measurement;
import az.personal.pma.entity.Product;
import az.personal.pma.entity.Price;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Data
public class TestRequest implements Serializable {
    private Product product;
    private List<Measurement> measurements;
    private List<Price> prices;
    private Long productId;
    private Integer measurementId;
    private Exchange exchange;
    private Integer currencyId;
}
