package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Counterparty {
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
}
