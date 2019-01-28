package BeNi.repository;

import BeNi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT b FROM Person b where b.personid = :personid")
    Person getById(@Param("personid") Long id);

    @Query("select b " +
            "from Person b " +
            "where (b.name LIKE :Name) " +
            "AND (b.surname LIKE :Surname) " +
            "AND (b.patronymic LIKE :Patronymic)")
    List<Person> filter(@Param("Name") String Name,
                        @Param("Surname") String Surname,
                        @Param("Patronymic") String Patronymic);

}
