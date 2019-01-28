package BeNi.Service;
import BeNi.entity.Person;
import java.util.List;

public interface PersonService {
    void addPerson(Person person);
    Person getById(Long id);
    List<Person> getAll();
    List<Person> filter(String Name,String Surname, String Patronymic, String Address);
}
