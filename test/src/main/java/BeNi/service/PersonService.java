package BeNi.service;

import BeNi.entity.Person;
import java.util.List;

public interface PersonService {

    void addPerson(Person person);
    void delete(Person person);
    Person getByName(String name);
    List<Person> getAll();

}
