package az.personal.pma.request;

import az.personal.pma.entity.Measurement;
import az.personal.pma.entity.Product;
import az.personal.pma.entity.ProductPrice;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TestRequest implements Serializable {
    private Product product;
    private List<Measurement> measurements;
    private List<ProductPrice> prices;
    private Long productId;
    private Integer measurementId;
}
