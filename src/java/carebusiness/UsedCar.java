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
@NamedQuery(name = "findAllUsedCars", query = "select c from Car c where type(c) = UsedCar")
public class UsedCar extends Car implements Serializable {

    private int odometer;
    private String regoNumber;
    private String regoExpiry;
    private String serviceHistory;
    private String vehicleIdNumber;
    private String carHistory;

    public UsedCar() {
    }

    public UsedCar(String make, String model, String deviceType, String color, String transmission, String engine,
            String engineType, String fuelType, int doors, int seats, int price, int odometer, String regoNumber,
            String regoExpiry, String serviceHistory, String vehicleIdNumber, String carHistory, int numberOfCars) {
        super(make, model, deviceType, color, transmission, engine,
                engineType, fuelType, doors, seats, price, 1);
        this.odometer = odometer;
        this.regoNumber = regoNumber;
        this.regoExpiry = regoExpiry;
        this.serviceHistory = serviceHistory;
        this.vehicleIdNumber = vehicleIdNumber;
        this.carHistory = carHistory;
    }

    /**
     * @return the odometer
     */
    public int getOdometer() {
        return odometer;
    }

    /**
     * @param odometer the odometer to set
     */
    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    /**
     * @return the regoNumber
     */
    public String getRegoNumber() {
        return regoNumber;
    }

    /**
     * @param regoNumber the regoNumber to set
     */
    public void setRegoNumber(String regoNumber) {
        this.regoNumber = regoNumber;
    }

    /**
     * @return the regoExpiry
     */
    public String getRegoExpiry() {
        return regoExpiry;
    }

    /**
     * @param regoExpiry the regoExpiry to set
     */
    public void setRegoExpiry(String regoExpiry) {
        this.regoExpiry = regoExpiry;
    }

    /**
     * @return the serviceHistory
     */
    public String getServiceHistory() {
        return serviceHistory;
    }

    /**
     * @param serviceHistory the serviceHistory to set
     */
    public void setServiceHistory(String serviceHistory) {
        this.serviceHistory = serviceHistory;
    }

    /**
     * @return the vehicleIdNumber
     */
    public String getVehicleIdNumber() {
        return vehicleIdNumber;
    }

    /**
     * @param vehicleIdNumber the vehicleIdNumber to set
     */
    public void setVehicleIdNumber(String vehicleIdNumber) {
        this.vehicleIdNumber = vehicleIdNumber;
    }

    /**
     * @return the carHistory
     */
    public String getCarHistory() {
        return carHistory;
    }

    /**
     * @param carHistory the carHistory to set
     */
    public void setCarHistory(String carHistory) {
        this.carHistory = carHistory;
    }

}
