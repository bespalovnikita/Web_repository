package BeNi.Service.impl;

import BeNi.Service.PersonService;
import BeNi.entity.House;
import BeNi.entity.Person;
import BeNi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {
        personRepository.saveAndFlush(person);
    }

    @Override
    public Person getById(Long id) { return personRepository.getById(id); }

    @Override
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    @Override
    public List<Person> filter(String Name, String Surname, String Patronymic, String Address) {
        if (Name.isEmpty()) Name="%";
        if (Surname.isEmpty()) Surname="%";
        if (Patronymic.isEmpty()) Patronymic="%";
        boolean noHomeOwner=false;

        List<Person> personList = personRepository.filter(Name, Surname, Patronymic);
        if(!Address.isEmpty()){
            List<Person> findList = new LinkedList<Person>();
            if ((Address.equals("-")
                    ||(Address.equals("null"))
                    ||(Address.equals("no"))
                    ||(Address.equals("NULL"))
                    ||(Address.equals("NO")))) noHomeOwner = true;

            House findedHouse = new House(Address);
            for(Person p : personList){
                if(p.findHouse(findedHouse, noHomeOwner)){
                    findList.add(p);
                }
            }
            return findList;
        }else return personList;
    }

}
