package BeNi.Service;
import BeNi.entity.Customer;
import java.util.List;

public interface CustomerService {
    void addCustomer(Customer Customer);
    List<Customer> getAll();
    Customer getById(Long id);
}