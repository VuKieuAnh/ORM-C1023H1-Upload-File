//package org.example.demoorm.repo.customer;
//
//import org.example.demoorm.model.entity.Customer;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.persistence.TypedQuery;
//import javax.transaction.Transactional;
//import java.util.List;
//@Transactional
//@Repository
//public class CustomerRepo implements ICustomerRepo {
//    @PersistenceContext
//    private EntityManager entityManager;
//    @Override
//    public List<Customer> findAll() {
//        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
//        return query.getResultList();
//    }
//
//    @Override
//    public Customer findById(Long id) {
//        return null;
//    }
//
//    @Override
//    public void save(Customer customer) {
//        if (customer.getId() != null) {
//            entityManager.merge(customer);
//        } else {
//            entityManager.persist(customer);
//        }
//    }
//
//    @Override
//    public void remove(Long id) {
//
//    }
//}
