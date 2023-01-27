package az.personal.pma.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private Date date;

    private Double amount;

    @ManyToOne(fetch = FetchType.LAZY)
    private Currency currency;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "operation")
    @JsonIgnore
    private Document document;

    @ManyToOne(fetch = FetchType.LAZY)
    private CashBox cashBox;

    @ManyToOne(fetch = FetchType.LAZY)
    private Counterparty counterparty;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "operation")
    private List<OtherCash> otherCashes = new ArrayList<>();

    @Column(length = 1000)
    private String note;

    public void addOtherCash(OtherCash otherCash) {
        this.otherCashes.add(otherCash);
    }

}
