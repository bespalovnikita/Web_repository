package BeNi.service.impl;
import BeNi.repository.PersonRepository;
import BeNi.entity.Person;
import BeNi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired private PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {
        personRepository.saveAndFlush(person);
    }

    @Override
    public Person getById(Long id) { return personRepository.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }


}
