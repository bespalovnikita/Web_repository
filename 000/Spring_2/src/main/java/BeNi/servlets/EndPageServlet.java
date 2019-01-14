package BeNi.servlets;

import BeNi.entity.Person;
import BeNi.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Configuration
@ComponentScan("BeNi")
public class EndPageServlet extends HttpServlet {

    @Autowired
    private PersonServiceImpl personService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Person person = personService.getById(0L);
    }
        /*String Name = request.getParameter("Name");
        String Surname = request.getParameter("Surname");
        String Patronymic = request.getParameter("Patronymic");
        Person person = new Person(Name,Surname,Patronymic);*/

        /*
        request.setAttribute("Name", Name);
        request.setAttribute("Surname", Surname);
        request.setAttribute("Patronymic", Patronymic);
        request.getRequestDispatcher("end.jsp").forward(request, response);
        */
     }

