package BeNi.entity;

import org.hibernate.Hibernate;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "personid", unique = true, nullable = false)
    private Long personid;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<House> houses;

    public List<House> getHouses() {return houses;}

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    @Transactional
    public boolean findHouse(House house, boolean noHomePersons){
        if ((noHomePersons)&(houses.size()==0)) return true;
        for (House h:houses){
            if (h.getAddress().equals(house.getAddress())) return true;
        }
        return false;
    }

    public Person(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Long getPersonid() {
        return personid;
    }

    public void setPersonid(Long personid) {
        this.personid = personid;
    }

    public boolean notEmpty() {
        if (name.isEmpty()&&surname.isEmpty()&&patronymic.isEmpty()) return false;
        return true;
    }
}