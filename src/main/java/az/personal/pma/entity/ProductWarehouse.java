package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductWarehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "warehouse_id")
    @JsonIgnore
    private Warehouse warehouse;

    @ManyToOne(fetch = FetchType.LAZY)
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
