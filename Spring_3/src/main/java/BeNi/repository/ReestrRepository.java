package BeNi.repository;

import BeNi.entity.Reestr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReestrRepository extends JpaRepository<Reestr, Long> {

    @Query("SELECT b FROM Reestr b where b.personid = :personid")
    Reestr getById(@Param("personid") Long id);

}
