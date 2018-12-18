package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String getForm() {
        return "mainPage";
    }

    @RequestMapping(value = "/end", method = RequestMethod.POST)
    public String saveDetails(@RequestParam("Name") String Name,
                              @RequestParam("Surname") String Surname,
                              @RequestParam("Patronymic") String Patronymic,
                              ModelMap modelMap) {
    Person person = new Person(Name,Surname,Patronymic);
    //  saveToDatabase(Name,Surname,Patronymic);
        personRepository.saveAndFlush(person);
        modelMap.put("Name", Name);
        modelMap.put("Surname", Surname);
        modelMap.put("Patronymic", Patronymic);
        return "end";
    }

    @RequestMapping("/foo")
    public String foo(Map<String, Object> model) {
        throw new RuntimeException("Foo");
    }
/*
    public void saveToDatabase(String Name,String Surname,String Patronymic) {

        String insertTableSQL = "INSERT INTO test.table " + "(Name, Surname, Patronymic) " + "VALUES " + "('" + Name + "','" + Surname + "','" + Patronymic + "');";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement statement = conn.createStatement();
            statement.executeUpdate(insertTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    */
}