package BeNi.service;
import BeNi.entity.Person;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PersonService {

    void addPerson(Person person);
    Person getById(Long id);
    List<Person> getAll();

}
