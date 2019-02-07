package BeNi.controller;

import BeNi.config.HibernateSessionFactory;
import BeNi.entity.*;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RESTController {

    Session session = HibernateSessionFactory.getSessionFactory().openSession();

    @GetMapping("/customers")
    public List<Customer> getCustomersGet() {
        List<Customer> list = session.createCriteria(Customer.class).list();
        return list;
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentListGet() {
        List<Department> list = session.createCriteria(Department.class).list();
        return list;
    }

    @GetMapping("/statuses")
    public List<Status> getStatusListGet() {
        List<Status> list = session.createCriteria(Status.class).list();
        return list;
    }

    @GetMapping("/doctypes")
    public List<Doctype> getDoctypeListGet() {
        List<Doctype> list = session.createCriteria(Doctype.class).list();
        return list;
    }

    @GetMapping("/documents")
    public List<Document> getDocumentListGet() {
        List<Document> list = session.createCriteria(Document.class).list();
        return list;
    }

    @GetMapping("/customers/{empNo}")
    public Customer getCustomerGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        List<Customer> resList = session.createCriteria(Customer.class)
                .add(Restrictions.eq("customer_id",id)).list();
        Customer res = resList.get(0);
        return res;
    }

    @GetMapping("/departments/{empNo}")
    public Department getDepartmentGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        List<Department> resList = session.createCriteria(Department.class)
                .add(Restrictions.eq("department_id",id)).list();
        Department res = resList.get(0);
        return res;
    }

    @GetMapping("/doctypes/{empNo}")
    public Doctype getDoctypeGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        List<Doctype> resList = session.createCriteria(Doctype.class)
                .add(Restrictions.eq("doctype_id",id)).list();
        Doctype res = resList.get(0);
        return res;
    }

    @GetMapping("/documents/{empNo}")
    public Document getDocumentGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        List<Document> resList = session.createCriteria(Document.class)
                .add(Restrictions.eq("document_id",id)).list();
        Document res = resList.get(0);
        return res;
    }

    @GetMapping("/statuses/{empNo}")
    public Status getStatusGet(@PathVariable("empNo") String empNo) {
        Long id = Long.valueOf(empNo);
        List<Status> resList = session.createCriteria(Status.class)
                .add(Restrictions.eq("status_id",id)).list();
        Status res = resList.get(0);
        return res;
    }



}