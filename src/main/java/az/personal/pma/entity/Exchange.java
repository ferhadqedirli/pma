package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Exchange {
    @Id
    @GeneratedValue
    private Integer id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private Date date;

    private Double rate;

    @ManyToOne
    @JsonIgnore
    private Currency currency;

    @PrePersist
    private void prePersist() {
        if (this.rate == null)
            this.rate = 1D;
    }

}
