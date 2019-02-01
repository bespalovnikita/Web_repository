package BeNi.repository;

import BeNi.entity.Reestr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReestrRepository extends JpaRepository<Reestr, Long> {

    @Query("SELECT b FROM Reestr b where b.r_id = :personid")
    Reestr getById(@Param("personid") Long id);

}
