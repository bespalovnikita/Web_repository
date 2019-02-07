package BeNi.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctype")
public class Doctype {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    @Column(name = "doctype_id", unique = true, nullable = false)
    private Long doctype_id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "document_id", insertable=false, updatable=false)
    private List<Document> docs;

    public Long getDoctype_id() {
        return doctype_id;
    }

    public void setDoctype_id(Long doctype_id) {
        this.doctype_id = doctype_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Document> getDocs() {
        return docs;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }
}
