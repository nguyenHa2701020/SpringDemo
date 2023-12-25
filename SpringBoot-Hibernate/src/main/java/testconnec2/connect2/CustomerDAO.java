package testconnec2.connect2;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository(value = "customerDAO")
@Transactional(rollbackFor = Exception.class)
public class CustomerDAO {
   @PersistenceContext
    private EntityManager entityManager;

    public void persist(final Customer customer) {
        entityManager.persist(customer);
    }

    public Customer findById(final int id) {
        return entityManager.find(Customer.class, id);
    }

    public void delete(final Customer customer) {
        entityManager.remove(customer);
    }

    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer").getResultList();
}
}