package BeNi.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "reestr")
public class Reestr {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "r_id", unique = true, nullable = false)
    private Long r_id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private Long code;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Customer> customers;

    public List<Customer> getCustomers() {return customers;}

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Reestr(String name, Long code) {
        this.name = name;
        this.code = code;
    }

    public Reestr() {
    }

    public Long getR_id() {
        return r_id;
    }

    public void setR_id(Long r_id) {
        this.r_id = r_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }
}