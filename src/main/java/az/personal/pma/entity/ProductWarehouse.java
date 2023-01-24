package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ProductWarehouse {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

    @ManyToOne
    private ProductMeasurement productMeasurement;

    private Double quantity;

    private Date dataDate;

    @PrePersist
    private void prePersist() {
        if (this.quantity == null)
            this.quantity = 0D;
        if (this.dataDate == null)
            this.dataDate = new Date();
    }

}
