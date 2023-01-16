package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Measurement {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank
    private String name;
}
