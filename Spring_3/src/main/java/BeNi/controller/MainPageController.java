package BeNi.controller;

import BeNi.Service.impl.CustomerServiceImpl;
import BeNi.Service.impl.ReestrServiceImpl;
import BeNi.config.HibernateSessionFactory;
import BeNi.entity.Customer;
import BeNi.entity.Reestr;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainPageController {

    @Autowired private ReestrServiceImpl reestrService;
    @Autowired private CustomerServiceImpl customerService;

    @GetMapping("/")
    public String main_page_get(ModelMap modelMap) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Customer.class)
                .add(Restrictions.eq("reestrid",1L))
                .add(Restrictions.in("code", new Long[] { 1L,2L}));
        List<Customer> customerList =     criteria.list();
        return "mainPage";
    }
}
