package BeNi.repository;

import BeNi.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface HouseRepository extends JpaRepository<House, Long> {

    @Query("select b from House b where b.houseid = :houseid")
    House getById(@Param("houseid") Long id);

}
