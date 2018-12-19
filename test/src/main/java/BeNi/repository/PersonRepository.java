package BeNi.repository;

import BeNi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("select b from table.test b where b.name = :name")
    Person findByName(@Param("name") String name);

}
