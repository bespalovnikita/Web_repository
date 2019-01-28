package BeNi.controller;

import BeNi.Service.impl.PersonServiceImpl;
import BeNi.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class RESTController {

    @Autowired private PersonServiceImpl personService;

    @PostMapping("/persons")
    public List<Person> getCustomersPost() {
        List<Person> list = personService.getAll();
        return list;
    }

    @GetMapping("/persons")
    public List<Person> getCustomersGet() {
        List<Person> list = personService.getAll();
        return list;
    }

    @GetMapping("/persons/{empNo}")
    public Person getCustomerGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        Person res = personService.getById(id);
        return res;
    }
    @PostMapping("/persons/{empNo}")
    public Person getCustomerPost(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        Person res = personService.getById(id);
        return res;
    }
}