package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Document implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private Integer modulId;

    private Integer documentTypeId;

    private Boolean active;

    private Boolean completed;

    @CreationTimestamp
    private Date dataDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private Date completeDate;

    @UpdateTimestamp
    private Date updateDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String number;

    @OneToOne(fetch = FetchType.LAZY)
    private Operation operation;
}
