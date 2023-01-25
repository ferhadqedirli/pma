package az.personal.pma.request;

import az.personal.pma.entity.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class TestRequest implements Serializable {
    public String date;
    private Product product;
    private List<Measurement> measurements;
    private List<Price> prices;
    private Long productId;
    private Integer measurementId;
    private Exchange exchange;
    private Integer currencyId;
    private Warehouse warehouse;
    private Branch branch;
    private Integer branchId;
    private Double quantity;
    private List<RecipeRequest> recipes;

    private String name;
    private Integer cashBoxType;
}
