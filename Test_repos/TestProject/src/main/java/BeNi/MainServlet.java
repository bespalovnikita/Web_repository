package BeNi;

import BeNi.entity.Person;
import BeNi.repository.Repos;
import org.apache.log4j.Logger;
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
public class MainServlet extends HttpServlet {  //маппинг для запуска /test

    private Logger log = Logger.getLogger(MainServlet.class);

    @Autowired private Repos repos;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger log = (Logger)getServletContext().getAttribute("log4");
        log.info("Enter to Servlet");
        System.out.println("tested");
        log.debug("Here is some DEBUG");
        log.info("Here is some INFO");
        log.warn("Here is some WARN");
        log.error("Here is some ERROR");
        log.fatal("Here is some FATAL");
        log.info("servlet");
        Person person = repos.getOne(0L);
    }
}