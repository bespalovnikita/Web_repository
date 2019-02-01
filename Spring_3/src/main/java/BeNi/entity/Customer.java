package BeNi.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "c_id", unique = true, nullable = false)
    private Long c_id;

    @Column(name = "reestrid")
    private Long reestrid;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "r_id", insertable=false, updatable=false)
    private Reestr owner;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(){}

    public Long getc_id() {
        return c_id;
    }

    public void setc_id(Long c_id) {
        this.c_id = c_id;
    }

    public Long getReestrid() {
        return reestrid;
    }

    public void setReestrid(Long reestrid) {
        this.reestrid = reestrid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Reestr getOwner() {
        return owner;
    }

    public void setOwner(Reestr owner) {
        this.owner = owner;
    }
}
