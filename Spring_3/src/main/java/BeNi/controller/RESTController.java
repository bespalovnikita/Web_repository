package BeNi.controller;

import BeNi.config.HibernateSessionFactory;
import BeNi.entity.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.Session;
import org.hibernate.StaleStateException;
import org.hibernate.Transaction;
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
    public List<Customer> getCustomers() {
        List<Customer> list = session.createCriteria(Customer.class).list();
        return list;
    }

    @GetMapping("/departments")
    public List<Department> getDepartmentList() {
        List<Department> list = session.createCriteria(Department.class).list();
        return list;
    }

    @GetMapping("/statuses")
    public List<Status> getStatusList() {
        List<Status> list = session.createCriteria(Status.class).list();
        return list;
    }

    @GetMapping("/doctypes")
    public List<Doctype> getDoctypeList() {
        List<Doctype> list = session.createCriteria(Doctype.class).list();
        return list;
    }

    @GetMapping("/documents")
    public List<Document> getDocumentList() {
        List<Document> list = session.createCriteria(Document.class).list();
        return list;
    }

    /**
     *
     * @param empNo Object index in database
     * @return Object
     */

    @GetMapping("/customers/{empNo}")
    public Customer getCustomer(@PathVariable("empNo") String empNo) {
        return (Customer) session.createCriteria(Customer.class)
                .add(Restrictions.eq("customer_id",Long.valueOf(empNo))).list().get(0);
    }

    @GetMapping("/departments/{empNo}")
    public List<Document> getDepartment(@PathVariable("empNo") String empNo) {
        Department res = new Department();
        try{ res = (Department) session.createCriteria(Department.class)
                .add(Restrictions.eq("department_id",Long.valueOf(empNo))).list().get(0);}
        catch (IndexOutOfBoundsException e){

        }
        return res.getDocs();
    }

    @GetMapping("/doctypes/{empNo}")
    public List<Document> getDoctype(@PathVariable("empNo") String empNo) {
        Doctype doctype = (Doctype) session.createCriteria(Doctype.class)
                .add(Restrictions.eq("doctype_id",Long.valueOf(empNo))).list().get(0);
        return doctype.getDocs();
    }

    @GetMapping("/statuses/{empNo}")
    public List<Document> getStatus(@PathVariable("empNo") String empNo) {
        Status status = (Status) session.createCriteria(Status.class).add(Restrictions.eq("status_id",Long.valueOf(empNo))).list().get(0);
        return status.getDocs();
    }

    @GetMapping("/documents/{empNo}")
    public Document getDocument(@PathVariable("empNo") String empNo) {
        return (Document) session.createCriteria(Document.class)
                .add(Restrictions.eq("document_id",Long.valueOf(empNo))).list().get(0);
    }
    /**
    Del or add department to document by department id
     */
    @GetMapping("/{empNo1}/department/{empNo2}/doc/{empNo3}")
    public void addDepartmentToDoc(@PathVariable("empNo1") String empNo1, @PathVariable("empNo2") String empNo2 , @PathVariable("empNo3") String empNo3) {
        if(empNo1.equals("add")||empNo1.equals("del")){
            Transaction transaction = session.beginTransaction();
            Department department = new Department();
            Document document = new Document();
            boolean alreadyContain;
            try {
                department = (Department) session.createCriteria(Department.class).add(Restrictions.eq("department_id", Long.valueOf(empNo2))).list().get(0);
                document = (Document) session.createCriteria(Document.class).add(Restrictions.eq("document_id", Long.valueOf(empNo3))).list().get(0);
                alreadyContain = department.getDocs().contains(document);
            } catch(IndexOutOfBoundsException e){
                return;
            }
            if(alreadyContain) return;
            if(empNo1.equals("add")){
                document.addDepartment(department);
                department.addDocument(document);
            }
            else {
                document.delDepartment(department);
                department.delDocument(document);
            }

            session.getTransaction().commit();
        }
    }


    /**
    Del or add customer/document/status/department/doctype by name
     */
    @GetMapping("/{empNo1}/{empNo2}/name/{empNo3}")
    public void add(@PathVariable("empNo1") String empNo1,@PathVariable("empNo2") String empNo2,@PathVariable("empNo3") String empNo3) {
        Transaction transaction = session.beginTransaction();
        if (empNo1.equals("add") || empNo1.equals("del")) {
            boolean add = empNo1.equals("add");
            switch (empNo2) {
                case "customer":
                    if(add) {
                        Customer customer = new Customer(empNo3);
                        session.saveOrUpdate(customer);
                    }
                    else {
                        List<Customer> customerList = session.createCriteria(Customer.class).add(Restrictions.eq("name",empNo3)).list();
                        for(Customer c:customerList) session.remove(c);
                    }
                    break;
                case "department":
                    if(add) {
                        Department department = new Department(empNo3);
                        session.saveOrUpdate(department);
                    }
                    else {
                        List<Department> departmentList = session.createCriteria(Department.class).add(Restrictions.eq("name",empNo3)).list();
                        for(Department c:departmentList) session.remove(c);
                    }
                case "doctype":
                    if(add) {
                        Doctype doctype = new Doctype(empNo3);
                        session.saveOrUpdate(doctype);
                    }
                    else {
                        List<Doctype> doctypeList = session.createCriteria(Doctype.class).add(Restrictions.eq("name",empNo3)).list();
                        for(Doctype c:doctypeList) session.remove(c);
                    }
                case "document":
                    if(add) {
                        Document document = new Document(empNo3);
                        session.saveOrUpdate(document);
                    }
                    else {
                        List<Document> customerList = session.createCriteria(Document.class).add(Restrictions.eq("name",empNo3)).list();
                        for(Document c:customerList) session.remove(c);
                    }
                case "status":
                    if(add) {
                        Status status = new Status(empNo3);
                        session.saveOrUpdate(status);
                    }
                    else {
                        List<Status> statusList = session.createCriteria(Status.class).add(Restrictions.eq("name",empNo3)).list();
                        for(Status c:statusList) session.remove(c);
                    }
            }
            session.getTransaction().commit();
        }
    }

    /**
     *
     * @param empNo1 "link"/"unlink"
     * @param empNo2 "customer/department/doctype/document/status"
     * @param empNo3 1,n
     * @param empNo4 "customer/department/doctype/document/status"
     * @param empNo5 1,n
     */
    @GetMapping("/{empNo1}/{empNo2}/{empNo3}/and/{empNo4}/{empNo5}")
    public void add(@PathVariable("empNo1") String empNo1,
                    @PathVariable("empNo2") String empNo2,
                    @PathVariable("empNo3") String empNo3,
                    @PathVariable("empNo4") String empNo4,
                    @PathVariable("empNo5") String empNo5) {
        Transaction transaction = session.beginTransaction();
        String entity;
        Long documentNumber;
        Long entityNumber;
        Document document;
        if ((empNo1.equals("link") || empNo1.equals("unlink"))&&
            ((empNo2.equals("document"))^(empNo4.equals("document")))
            ){
            boolean link = empNo1.equals("link");
        if(empNo2.equals("document")) {
            documentNumber = Long.valueOf(empNo3);
            entityNumber = Long.valueOf(empNo5);
            entity = empNo4;}
        else{
            documentNumber = Long.valueOf(empNo5);
            entityNumber = Long.valueOf(empNo3);
            entity = empNo2;
        }
        document = (Document) session.createCriteria(Document.class).add(Restrictions.eq("document_id",documentNumber)).list().get(0);
            switch(entity){
                case "department":{
                Department department = (Department) session.createCriteria(Department.class).add(Restrictions.eq("department_id",entityNumber)).list().get(0);
                if(link){
                    department.addDocument(document);
                    document.addDepartment(department);}
                else{
                    if(department.getDocs().contains(document)) {
                        department.delDocument(document);
                    }
                    if(document.getDepartments().contains(department)){
                        document.delDepartment(department);
                    }
                }
                break;
                }
                case "doctype":{
                    Doctype doctype = (Doctype) session.createCriteria(Doctype.class).add(Restrictions.eq("doctype_id",entityNumber)).list().get(0);
                    if(link){
                        doctype.addDocument(document);
                        document.setDoctype(doctype);}
                    else{
                        doctype.delDocument(document);
                        document.delDoctype(doctype);
                    }
                break;
                }
                case "status":{
                    Status status = (Status) session.createCriteria(Status.class).add(Restrictions.eq("status_id",entityNumber)).list().get(0);
                    if(link){
                        status.addDocument(document);
                        document.setStatus(status);
                    }
                    else{
                        status.delDocument(document);
                        document.delStatus(status);
                    }
                break;
                }
                case "customer":{
                    Customer customer = (Customer) session.createCriteria(Customer.class).add(Restrictions.eq("customer_id",entityNumber)).list().get(0);
                    if(link){
                        customer.addDocument(document);
                        document.setOwner(customer);
                    }
                    else{
                        customer.delDocument(document);
                        document.delOwner(customer);
                    }
                break;
                }

            }
        session.getTransaction().commit();
        }

        }
    }