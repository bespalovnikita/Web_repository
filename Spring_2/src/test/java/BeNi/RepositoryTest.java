package BeNi;

import BeNi.entity.House;
import BeNi.entity.Person;
import BeNi.repository.HouseRepository;
import BeNi.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RepositoryTest {

    @Autowired private PersonRepository personRepository;
    @Autowired private HouseRepository houseRepository;

    @Test
    public void testPersonRepository(){
    Person pTest = new Person("test1","test2","test3");
    personRepository.saveAndFlush(pTest);

    List<Person> testList = personRepository.findAll();
    assertEquals(pTest,testList.get(0));

    Person pTest2 = personRepository.getById((long) 1);
    assertEquals(pTest,pTest2);

    personRepository.delete(pTest);
    List<Person> testList2 = personRepository.findAll();
    assertEquals(testList2.size(),0);

    Person pTest3 = personRepository.getById((long) 1);
    assertEquals(null,pTest3);

    System.out.println("testPersonRepository completed");
    }

    @Test
    public void testHouseRepository(){
        House pTest = new House("test1","test2");
        houseRepository.saveAndFlush(pTest);

        List<House> testList = houseRepository.findAll();
        assertEquals(pTest,testList.get(0));

        House pTest2 = houseRepository.getById(1L);
        assertEquals(pTest,pTest2);

        houseRepository.delete(pTest);

        List<House> testList2 = houseRepository.findAll();
        assertEquals(testList2.size(),0);

        House pTest3 = houseRepository.getById(1L);
        assertEquals(null,pTest3);

        System.out.println("testHouseRepository completed");
    }


}