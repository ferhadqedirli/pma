package az.personal.pma.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Exchange {
    @Id
    @GeneratedValue
    private Integer id;

    private Date date;

    @ManyToOne
    private Currency currency;

    @ColumnDefault("1.0")
    private Double rate;
}
