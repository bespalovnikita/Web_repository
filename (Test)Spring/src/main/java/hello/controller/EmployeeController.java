package hello.controller;

import hello.entity.Persone;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class EmployeeController {

    static String url = "jdbc:mysql://localhost:3306/test?useTimezone=true&serverTimezone=UTC";
    static String user = "root";
    static String password = "test";

    @GetMapping("/")
    public String getForm() {

        return "mainPage";

    }


    @PostMapping("/end")
    public String saveDetails(@RequestParam("Name") String Name,
                              @RequestParam("Surname") String Surname,
                              @RequestParam("Patronymic") String Patronymic,
                              ModelMap modelMap) {
        Persone persone = new Persone(Name,Surname,Patronymic);
        saveToDatabase(Name,Surname,Patronymic);
        modelMap.put("Name", Name);
        modelMap.put("Surname", Surname);
        modelMap.put("Patronymic", Patronymic);

        return "end";
    }

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
}