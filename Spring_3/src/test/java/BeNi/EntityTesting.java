package BeNi;

import BeNi.entity.House;
import BeNi.entity.Person;
import org.junit.Test;
import org.springframework.test.context.web.WebAppConfiguration;
import static org.junit.Assert.assertEquals;

@WebAppConfiguration
public class EntityTesting {

    @Test
    public void personConstructorTest(){
        Person pTest = new Person("Nikita", "Bespalov", "Sergeevich");
        assertEquals("Nikita",pTest.getName());
        assertEquals("Bespalov",pTest.getSurname());
        assertEquals("Sergeevich",pTest.getPatronymic());
        assertEquals(pTest.getPersonid(), null);
        assertEquals(pTest.getHouses(), null);
        assertEquals(true,pTest.notEmpty());
        System.out.println("personConstructorTest completed");
    }

    @Test
    public void houseConstructorTest(){
        House hTest = new House("address");
        assertEquals(hTest.getAddress(),"address");
        assertEquals(hTest.getPersonid(), null);

        System.out.println("houseConstructorTest completed");
    }

}
