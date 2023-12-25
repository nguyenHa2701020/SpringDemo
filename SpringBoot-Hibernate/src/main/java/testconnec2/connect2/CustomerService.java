package testconnec2.connect2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerService {
    @Autowired
    private CustomerDAO customerDAO;

    public List<Customer> findAll() {
        return customerDAO.findAll();
    }

    public Customer findById(int id) {
        return customerDAO.findById(id);
    }

    public void save(Customer customer) {
        // validate business
        customerDAO.persist(customer);
    }

    public void update(Customer customer) {
        Customer customerDb = customerDAO.findById(customer.getId());
        customerDb.setName(customer.getName());
        customerDb.setAddress(customer.getAddress());
        customerDAO.persist(customerDb);

    }

    public void delete(int id) {
        Customer cm=this.findById(id);
        // validate business
        customerDAO.delete(cm);
    }
}
