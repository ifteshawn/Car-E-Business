/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Ifte
 */
@Entity
@Table(name = "Customer_Orders")
@NamedQuery(name = "findAllOrders", query = "select o from CustomerOrder o")
public class CustomerOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Car car;
    @Column(name = "QUANTITY")
    private int qtyOfCar;
    @Column(name = "DATECREATED")
    @Temporal(TemporalType.DATE)
    private Date dateCreated;
    @Column(name = "UNITPRICE")
    private double unitPrice;
    @Column(name = "TOTALPRICE")
    private double totalPrice;

    public CustomerOrder() {

    }

    public CustomerOrder(Customer customer, Car car, int qtyOfCar, Date dateCreated, double unitPrice, double totalPrice) {
        this.customer = customer;
        this.car = car;
        this.qtyOfCar = qtyOfCar;
        this.dateCreated = new Date();
        this.unitPrice = car.getPrice();
        this.totalPrice = totalPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public int getQtyOfCar() {
        return qtyOfCar;
    }

    public void setQtyOfCar(int qtyOfCar) {
        this.qtyOfCar = qtyOfCar;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = car.getPrice();
    }

    public double getUnitPrice() {
        return this.unitPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = car.getPrice() * this.qtyOfCar;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "carebusiness.CustomerOrder[ id=" + id + " ]";
    }

}
