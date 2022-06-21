/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ifte
 */
@Stateless
public class CustomerEJB {

    /**
     *
     */
    @PersistenceContext(unitName = "CarEBusinessPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    public List<Customer> findCustomers() {
        Query query = em.createNamedQuery("findAllCustomers");
        return query.getResultList();
    }

    /**
     *
     * @param newCustomer
     * @return
     */
    public Customer createNewCustomer(Customer newCustomer) {
        em.persist(newCustomer);
        return newCustomer;
    }

    /**
     *
     * @param name
     * @return
     */
    public List<Customer> findACustomer(String name) {
        String jpqlQuery = "select c from Customer c where c.name = :newcustomername";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("newcustomername", name);
        List<Customer> customerListResult = query.getResultList();
        return customerListResult;
    }

}
