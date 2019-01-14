package BeNi.service;
import BeNi.entity.Person;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Controller
public interface PersonService {

    void addPerson(Person person);
    Person getById(Long id);
    List<Person> getAll();
    void delete(Person person);
    void delete(long id);
}
