package BeNi.repository;

import BeNi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select b from Customer b where b.c_id = :houseid")
    Customer getById(@Param("houseid") Long id);

}
