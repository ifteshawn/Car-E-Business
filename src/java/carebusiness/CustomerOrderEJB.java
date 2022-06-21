/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Ifte
 */
@Stateless
public class CustomerOrderEJB {

    //Attributes             
    @PersistenceContext(unitName = "CarEBusinessPU")
    private EntityManager em;

    public List<CustomerOrder> findOrders() {
        Query query = em.createNamedQuery("findAllOrders");
        return query.getResultList();
    }

    public List<CustomerOrder> findOrderById(long id) {
        String jpqlQuery = "SELECT o FROM CustomerOrder o WHERE o.id = :customerorderid";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("customerorderid", id);
        List<CustomerOrder> customerOrderListResult = query.getResultList();
        return customerOrderListResult;
    }

    public CustomerOrder createOrder(CustomerOrder order){
        
        order.setUnitPrice(order.getCar().getPrice());
        order.setTotalPrice(order.getUnitPrice() * order.getQtyOfCar());
        order.setDateCreated(Date.from(Instant.now()));
        em.persist(order);
        String jpqlQuery = "select c from Car c where c.id = :newcarid";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("newcarid", order.getCar().getId());
        List<Car> carListResult = query.getResultList();

        if (!carListResult.isEmpty()) {
            //update number of cars left
            int newNumber = carListResult.get(0).getNumberOfCars() - order.getQtyOfCar();
            //check if there are anough cars in stock
            if(newNumber < 0){
                throw new IllegalArgumentException("There are no enough cars in stock to process this order");
            }
            order.getCar().setNumberOfCars(newNumber);
            em.merge(order.getCar());
        }
        
        return order;
    }

    public void deleteOrder(CustomerOrder order) {
        
        int numberOfCars = order.getCar().getNumberOfCars() + order.getQtyOfCar();
        order.getCar().setNumberOfCars(numberOfCars);
        em.merge(order.getCar());
        
        
        CustomerOrder toBeRemoved = em.merge(order);
        em.remove(toBeRemoved);
    }

    public List<CustomerOrder> findOrdersByCustomerId(long id) {
        String jpqlQuery = "SELECT o FROM CustomerOrder o WHERE o.customer.id = :customerid";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("customerid", id);
        List<CustomerOrder> customerOrderListResult = query.getResultList();
        return customerOrderListResult;
    }


}
