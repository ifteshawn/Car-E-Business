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
 * @author Natha
 */
@Stateless
public class CarEJB {

    //Attributes             
    @PersistenceContext(unitName = "CarEBusinessPU")
    private EntityManager em;

    //Public methods           
    public List<Car> findNewCars() {
        Query query = em.createNamedQuery("findAllNewCars");
        return query.getResultList();
    }

    public Car createNewCar(Car newCar) {
        em.persist(newCar);
        return newCar;
    }

    public List<Car> findANewCar(String id) {
        String jpqlQuery = "select c from Car c where type(c) = NewCar AND c.id = :newcarid";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("newcarid", id);
        List<Car> carListResult = query.getResultList();
        return carListResult;
    }

    public List<Car> findUsedCars() {
        Query query = em.createNamedQuery("findAllUsedCars");
        return query.getResultList();
    }

    public List<Car> findAUsedCar(String id) {
        String jpqlQuery = "select c from Car c where type(c) = UsedCar AND c.id = :usedcarid";
        Query query = em.createQuery(jpqlQuery);
        query.setParameter("usedcarid", id);
        List<Car> carListResult = query.getResultList();
        return carListResult;
    }

    public Car createUsedCar(Car usedCar) {
        em.persist(usedCar);
        return usedCar;
    }
}
