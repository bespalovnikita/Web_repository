package BeNi;

import BeNi.entity.Person;
import BeNi.repository.PersonRepository;
import BeNi.service.PersonService;
import BeNi.service.impl.PersonServiceImpl;
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

    @Autowired
    private PersonService personService;

    @MockBean
    private PersonRepository personRepository;

    @Test public void test1(){
        Person pTest = personService.getById((long)0);
    }

    @Before
    public void setUp() {
        Person alex = new Person("Alex", "Kharotnov", "Igor'evich");
        Mockito.when(personRepository.getById((long) 0)).thenReturn(alex);
    }
}