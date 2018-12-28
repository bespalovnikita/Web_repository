package BeNi;

import BeNi.entity.Person;
import BeNi.repository.PersonRepository;
import BeNi.service.PersonService;
import BeNi.service.impl.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MockTest {

    @TestConfiguration
    static class TestConfig {

        @Bean
        public PersonService employeeService() {
            return new PersonServiceImpl();
        }
    }

    @Autowired private PersonService personService;

    @MockBean private PersonRepository personRepository;

    @Test public void mockTest(){
        Person pTest = personService.getById(0L);
        long id = 12345;
        long pTestId = pTest.getPersonid();
        Assert.assertEquals(id,pTestId);


        Assert.assertEquals(pTest.getName(),"Alex");
        Assert.assertEquals(pTest.getSurname(),"Kharitonov");
        Assert.assertEquals(pTest.getPatronymic(),"Igor'evich");

        System.out.println("mockTest Completed");

    }

    @Before
    public void setUp() {
        Person alex = new Person("Alex", "Kharitonov", "Igor'evich");
        alex.setPersonid(12345L);
        Mockito.when(personRepository.getById(0L)).thenReturn(alex);
    }
}