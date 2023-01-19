package az.personal.pma.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Measurement {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(nullable = false, unique = true, length = 20)
    @NotBlank
    private String name;

    @OneToMany(mappedBy = "measurement")
    private List<ProductMeasurement> products = new ArrayList<>();

}
