package hello.entity;

import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

@Table(name = "test")
public class Persone {

    @Column(name = "Name")
    private String Name;

    @Column(name = "Surname")
    private String Surname;

    @Column(name = "Patronymic")
    private String Patronymic;

    public Persone(String Name, String Surname, String Patronymic) {
        this.Name = Name;
        this.Surname = Surname;
        this.Patronymic = Patronymic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getPatronymic() {
        return Patronymic;
    }

    public void setPatronymic(String Patronymic) {
        this.Patronymic = Patronymic;
    }


}
