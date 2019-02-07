package BeNi.controller;

import BeNi.config.HibernateSessionFactory;
import BeNi.entity.Customer;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {

    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    @PostMapping("/cust")
    public List<Customer> getCustomersPost() {
        List<Customer> list = session.createCriteria(Customer.class).list();
        return list;
    }

    @GetMapping("/cust")
    public List<Customer> getCustomersGet() {
        List<Customer> list = session.createCriteria(Customer.class).list();
        return list;
    }
/*
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
    }*/
}