package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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

    @Column(scale = 2)
    private Double assets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cashBox")
    @JsonIgnore
    private List<Operation> operations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cashBox")
    @JsonIgnore
    private List<OtherCash> otherCashes = new ArrayList<>();

    public CashBox(String name, Integer cashBoxType, Branch branch) {
        this.name = name;
        this.cashBoxType = cashBoxType;
        this.branch = branch;
    }
}
