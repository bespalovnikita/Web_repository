package BeNi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "document")
public class Document {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "document_id", unique = true, nullable = false)
    private Long document_id;

    @Column(name = "name")
    private String name;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "doctype_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Doctype doctype;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", insertable = false, updatable = false)
    @JsonBackReference
    private Customer owner;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id", insertable = false, updatable = false)
    @JsonManagedReference
    private Status status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "document_department",
            joinColumns = @JoinColumn(name = "document_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    @JsonManagedReference
    private List<Department> departments;

    public List<Department> getDepartments() {
        return departments;
    }

    public Document(String name) {
        this.name = name;
    }

    public Document() {
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getDocument_id() {
        return document_id;
    }

    public void setDocument_id(Long document_id) {
        this.document_id = document_id;
    }

    public Doctype getDoctype() {
        return doctype;
    }

    public void setDoctype(Doctype doctype) {
        this.doctype = doctype;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setOwner(Customer owner) {
        this.owner = owner;
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void delDepartment(Department department) {
        departments.remove(department);
    }

    public void delDoctype(Doctype doctype) {
        if (doctype.getDoctype_id() == this.doctype.getDoctype_id()) {
            this.doctype = null;
        }

    }

    public void delStatus(Status status) {
        if (status.getStatus_id() == this.status.getStatus_id()) {
            this.status = null;
        }
    }

    public void delOwner(Customer customer) {
        if (customer.getCustomer_id() == this.owner.getCustomer_id()) {
            this.owner = null;
        }
    }
}
