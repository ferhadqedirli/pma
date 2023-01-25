package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CashBox implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    private Integer cashBoxType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Branch branch;

    public CashBox(String name, Integer cashBoxType, Branch branch) {
        this.name = name;
        this.cashBoxType = cashBoxType;
        this.branch = branch;
    }
}
