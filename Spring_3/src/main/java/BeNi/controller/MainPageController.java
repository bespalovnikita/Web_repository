package BeNi.controller;

import BeNi.config.HibernateSessionFactory;
import BeNi.entity.Customer;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {


    @GetMapping("/")
    public String main_page_get(ModelMap modelMap) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Customer.class);
        List<Customer> customerList = criteria.list();
        modelMap.addAttribute("customerList", customerList);
        return "mainPage";
    }
}
