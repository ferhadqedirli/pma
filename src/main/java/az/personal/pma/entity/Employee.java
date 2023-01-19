package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false)
    @NotBlank
    private String fullName;

    private String phone;

    private String address;

    private String note;
}
