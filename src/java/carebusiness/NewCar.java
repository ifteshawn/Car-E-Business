/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

/**
 *
 * @author Natha
 */
@Entity
@NamedQuery(name = "findAllNewCars", query = "select c from Car c where type(c) = NewCar")
public class NewCar extends Car implements Serializable {

    private int warranty;
    private int extendingWarranty;
    private String roadSideAssistancePackage;

    public NewCar() {
    }

    public NewCar(String make, String model, String deviceType, String color, String transmission, String engine,
            String engineType, String fuelType, int doors, int seats, int price, int warranty, int extendingWarranty, String roadSideAssistancePackage, int numberOfCars) {
        super(make, model, deviceType, color, transmission, engine,
                engineType, fuelType, doors, seats, price, numberOfCars);
        this.warranty = warranty;
        this.extendingWarranty = extendingWarranty;
        this.roadSideAssistancePackage = roadSideAssistancePackage;
    }

    /**
     * @return the warranty
     */
    public int getWarranty() {
        return warranty;
    }

    /**
     * @param warranty the warranty to set
     */
    public void setWarranty(int warranty) {
        this.warranty = warranty;
    }

    /**
     * @return the extendingWarranty
     */
    public int getExtendingWarranty() {
        return extendingWarranty;
    }

    /**
     * @param extendingWarranty the extendingWarranty to set
     */
    public void setExtendingWarranty(int extendingWarranty) {
        this.extendingWarranty = extendingWarranty;
    }

    /**
     * @return the roadSideAssistancePackage
     */
    public String getRoadSideAssistancePackage() {
        return roadSideAssistancePackage;
    }

    /**
     * @param roadSideAssistancePackage the roadSideAssistancePackage to set
     */
    public void setRoadSideAssistancePackage(String roadSideAssistancePackage) {
        this.roadSideAssistancePackage = roadSideAssistancePackage;
    }

}
