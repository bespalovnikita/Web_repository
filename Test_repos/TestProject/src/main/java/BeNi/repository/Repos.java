package BeNi.repository;

import BeNi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Repos extends JpaRepository<Person, Long> {

}
