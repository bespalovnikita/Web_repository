package BeNi.service;
import BeNi.entity.Person;
import java.util.List;

public interface PersonService {

    void addPerson(Person person);
    Person getById(Long id);
    List<Person> getAll();

}
