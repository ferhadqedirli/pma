package az.personal.pma.entity.embedded;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class ProductMeasurementId implements Serializable {
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "measurement_id")
    private Integer measurementId;
}
