/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Natha
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Car implements Serializable {

    //private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String make;
    private String model;
    private String driveType;
    private String color;
    private String transmission;
    private String engine;
//    private String engineType;
    private String fuelType;
    private int doors;
    private int seats;
    private int price;
    private int numberOfCars;

    public Car() {
    }

    public Car(String make, String model, String deviceType, String color, String transmission, String engine, String engineType, String fuelType, int doors, int seats, int price, int numberOfCars) {
        this.make = make;
        this.model = model;
        this.driveType = deviceType;
        this.color = color;
        this.transmission = transmission;
        this.engine = engine;
//        this.engineType = engineType;
        this.fuelType = fuelType;
        this.doors = doors;
        this.seats = seats;
        this.price = price;
        this.numberOfCars = numberOfCars;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Car)) {
            return false;
        }
        Car other = (Car) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "carebusiness.Car[ id=" + id + " ]";
    }

    /**
     * @return the make
     */
    public String getMake() {
        return make;
    }

    /**
     * @param make the make to set
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the driveType
     */
    public String getDriveType() {
        return driveType;
    }

    /**
     * @param driveType the driveType to set
     */
    public void setDriveType(String driveType) {
        this.driveType = driveType;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the transmission
     */
    public String getTransmission() {
        return transmission;
    }

    /**
     * @param transmission the transmission to set
     */
    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    /**
     * @return the engine
     */
    public String getEngine() {
        return engine;
    }

    /**
     * @param engine the engine to set
     */
    public void setEngine(String engine) {
        this.engine = engine;
    }

//    /**
//     * @return the engineType
//     */
//    public String getEngineType() {
//        return engineType;
//    }
//
//    /**
//     * @param engineType the engineType to set
//     */
//    public void setEngineType(String engineType) {
//        this.engineType = engineType;
//    }

    /**
     * @return the fuelType
     */
    public String getFuelType() {
        return fuelType;
    }

    /**
     * @param fuelType the fuelType to set
     */
    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return the doors
     */
    public int getDoors() {
        return doors;
    }

    /**
     * @param doors the doors to set
     */
    public void setDoors(int doors) {
        this.doors = doors;
    }

    /**
     * @return the seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * @param seats the seats to set
     */
    public void setSeats(int seats) {
        this.seats = seats;
    }

    /**
     * @return the numberOfCars
     */
    public int getNumberOfCars() {
        return numberOfCars;
    }

    /**
     * @param numberOfCars the numberOfCars to set
     */
    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

}
