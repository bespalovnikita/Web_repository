package BeNi;

import BeNi.Service.PersonService;
import BeNi.config.AppInit;
import BeNi.config.WebConfig;
import BeNi.entity.House;
import BeNi.entity.Person;
import BeNi.Service.HouseService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppInit.class, WebConfig.class})
@WebAppConfiguration
public class ServiceTest {

    @Autowired private HouseService houseService;
    @Autowired private PersonService personService;

    @Test
    @Transactional
    public void serviceTest(){
        House hTest = new House("address");
        houseService.addHouse(hTest);
        Person pTest = new Person("name", "surname", "patronymic");
        personService.addPerson(pTest);
        Long pTestId = pTest.getPersonid();
        houseService.link(pTestId,hTest);
        Assert.assertEquals(hTest.getPersonid(),pTest.getPersonid());

        System.out.println("serviceTest completed");
    }
}