package az.personal.pma.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Where(clause = "active = true")
@SQLDelete(sql = "update cash_box set active = false where id = ?")
public class CashBox {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    @ColumnDefault(value = "1")
    private boolean active;

    @PreRemove
    private void preRemove() {
        this.active = false;
    }
}
