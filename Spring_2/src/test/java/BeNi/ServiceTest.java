package BeNi;

import BeNi.entity.House;
import BeNi.entity.Person;
import BeNi.repository.HouseRepository;
import BeNi.service.HouseService;
import BeNi.service.impl.HouseServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServiceTest {

    @TestConfiguration
    static class TestConfig {
       @Bean public HouseService houseService() {
           return new HouseServiceImpl();
        }
    }

    @Autowired private HouseService houseService;

    @MockBean private HouseRepository houseRepository;

    @Test
    public void serviceTest(){

        House hTest = new House("address","housetype");
        hTest.setHouseid(555L);
        Person pTest = new Person("name", "surname", "patronymic");
        pTest.setPersonid(666L);
        houseService.link(pTest.getPersonid(),hTest);
        Assert.assertEquals(hTest.getPersonid(),pTest.getPersonid());

        System.out.println("serviceTest completed");
    }
}