package BeNi;

import java.util.List;

import BeNi.entity.Person;
import BeNi.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainRESTController {

    @Autowired private PersonService personService;

    @RequestMapping(value = "/persons",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<Person> getPersons() {
        List<Person> list = personService.getAll();
        return list;
    }

    @RequestMapping(value = "/persons/{empNo}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public Person getEmployee(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        Person res = personService.getById(id);
        return res;
    }

}