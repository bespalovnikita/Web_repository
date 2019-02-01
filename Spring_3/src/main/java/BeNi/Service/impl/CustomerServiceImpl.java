package BeNi.Service.impl;

import BeNi.Service.CustomerService;
import BeNi.entity.Customer;
import BeNi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired private CustomerRepository customerRepository;

    @Override
    public void addCustomer(Customer customer) {
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public Customer getById(Long id) {return customerRepository.getById(id);
    }

    @Override
    public List<Customer> getAll() {
    return customerRepository.findAll();
    }

}
