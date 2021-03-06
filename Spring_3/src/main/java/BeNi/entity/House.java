package BeNi.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Entity
@Table(name = "house")
public class House {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "houseid", unique = true, nullable = false)
    private Long houseid;

    @Column(name = "address")
    private String address;

    @Column(name = "personid")
    private Long personid;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "personid", insertable=false, updatable=false)
    private Person owner;

    public House(String address) {
        this.address = address;
    }

    public House(){}

    public Long getHouseid() {
        return houseid;
    }

    public void setHouseid(Long houseid) {
        this.houseid = houseid;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean notEmpty() {
        return address.isEmpty();
    }

}
