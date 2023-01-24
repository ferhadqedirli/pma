package az.personal.pma.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class RecipeRequest implements Serializable {
    private Double quantity;
    private Long productId;
    private Integer measurementId;
}
