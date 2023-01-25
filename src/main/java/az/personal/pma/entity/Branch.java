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
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String address;

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private final List<Warehouse> warehouses = new ArrayList<>();

    @OneToMany(mappedBy = "branch", fetch = FetchType.LAZY)
    private final List<CashBox> cashBoxes = new ArrayList<>();

    public void addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
    }

    public void addCashBox(CashBox cashBox) {
        this.cashBoxes.add(cashBox);
    }

    public void removeCashBoxes(CashBox cashBox) {
        this.cashBoxes.remove(cashBox);
    }
}
