package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Counterparty implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String name;

    private String address;

    private String phone;

    private String mobile;

    @Column(scale = 2)
    private Double saleRate;

    private String note;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "counterparty")
    @JsonIgnore
    private List<Operation> operations = new ArrayList<>();


}
