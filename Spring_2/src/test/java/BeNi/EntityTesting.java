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
        assertEquals(pTest.getName(),"Nikita");
        assertEquals(pTest.getSurname(),"Bespalov");
        assertEquals(pTest.getPatronymic(),"Sergeevich");
        assertEquals(pTest.getPersonid(), null);
        assertEquals(pTest.getHouses(), null);

        System.out.println("personConstructorTest completed");
    }

    @Test
    public void houseConstructorTest(){
        House hTest = new House("address","housetype");
        assertEquals(hTest.getAddress(),"address");
        assertEquals(hTest.getHousetype(),"housetype");
        assertEquals(hTest.getPersonid(), null);

        System.out.println("houseConstructorTest completed");
    }

}
