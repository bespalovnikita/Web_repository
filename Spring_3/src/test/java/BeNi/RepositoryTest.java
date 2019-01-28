package BeNi;

import BeNi.Service.HouseService;
import BeNi.Service.PersonService;
import BeNi.config.AppInit;
import BeNi.config.WebConfig;
import BeNi.entity.House;
import BeNi.entity.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppInit.class, WebConfig.class})
@WebAppConfiguration
public class RepositoryTest {

    @Autowired private PersonService personService;
    @Autowired private HouseService houseService;

    @Test
    @Transactional
    public void testPersonRepository(){
    Person pTest1 = new Person("test1","test2","test3");
    personService.addPerson(pTest1);
    Long pTestIdLong = pTest1.getPersonid();
    assertEquals("test1", pTest1.getName());
    assertEquals("test2", pTest1.getSurname());
    assertEquals("test3", pTest1.getPatronymic());
    assertEquals(null, pTest1.getHouses());
    List<Person> testList = personService.getAll();
    assertEquals(true, testList.size()>0);

    Person pTest2 = personService.getById(pTestIdLong);
    assertEquals(pTest1.getName(),pTest2.getName());
    assertEquals(pTest1.getSurname(),pTest2.getSurname());
    assertEquals(pTest1.getPatronymic(),pTest2.getPatronymic());
    assertEquals(pTest1.getHouses(),pTest2.getHouses());

    System.out.println("testPersonRepository completed");

    }

    @Test
    @Transactional
    public void testHouseRepository(){
        House hTest1 = new House("test1");
        houseService.addHouse(hTest1);
        Long hTestIdLong = hTest1.getHouseid();
        List<House> testList = houseService.getAll();
        assertEquals(true, testList.size()>0);
        assertEquals(null, hTest1.getPersonid());

        House hTest2 = houseService.getById(hTestIdLong);
        assertEquals(hTest1.getAddress(), hTest2.getAddress());
        assertEquals(hTest1.getPersonid(), hTest2.getPersonid());
        assertEquals(hTest1.getHouseid(), hTest2.getHouseid());
        System.out.println("testHouseRepository completed");

    }

}