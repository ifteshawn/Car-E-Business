/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

//import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Natha
 */
//@Named(value = "carController")carController
@ManagedBean(name = "carController")
@RequestScoped
public class CarController {

    //Attributes             
    @EJB
    private CarEJB carEJB;
    private Car newCar = new NewCar();
    private List<Car> newCarList = new ArrayList<>();
    private List<Car> newCarFiltered = new ArrayList<>();
    private Car usedCar = new UsedCar();
    private List<Car> usedCarList = new ArrayList<>();
    private List<Car> usedCarFiltered = new ArrayList<>();
    
    //Public methods           
    public String newCarForm() {
        return "createNewCar.xhtml";
    }
    
    public String usedCarForm() {
        return "createUsedCar.xhtml";
    }

    public String createNewCar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        
        try {
            newCar = carEJB.createNewCar(newCar);
            ctx.addMessage("displayNewCarMessage:newCarMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "The new Car has been created", "Successfully created the new brand new car: " + newCar.getMake() + " " + newCar.getModel()));
        } catch (Exception e) {
            ctx.addMessage("displayNewCarMessage:newCarMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The new Car hasn't been created", e.getMessage()));
        }
        
        return "stockOfNewCar.xhtml";
    }
    
    public String createUsedCar() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        usedCar.setNumberOfCars(1);
        
        try {
            usedCar = carEJB.createUsedCar(usedCar);
            ctx.addMessage("displayUsedCarMessage:usedCarMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "The used Car has been created", "Successfully created the used car: " + usedCar.getMake() + " " + usedCar.getModel()));
        } catch (Exception e) {
            ctx.addMessage("displayUsedCarMessage:usedCarMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The used Car hasn't been created", e.getMessage()));
        }
        
        return "stockOfUsedCar.xhtml";
    }
    
    public String searchNewCar(){
        newCarFiltered = carEJB.findANewCar(newCar.getId());
        return "foundNewCar.xhtml";
    }
    
    public String getNewCarDetails(String id){
        newCarFiltered = carEJB.findANewCar(id);
        return "/Car/foundNewCar.xhtml";
    }
    
    public String getCarDetails(Car car){
        if (car instanceof NewCar){
            return getNewCarDetails(car.getId());
        }
        if(car instanceof UsedCar){
            return getUsedCarDetails(car.getId());
        }
        
        return "";
    }
    
    public String searchUsedCar(){
        usedCarFiltered = carEJB.findAUsedCar(usedCar.getId());
        return "foundUsedCar.xhtml";
    }
    
    public String getUsedCarDetails(String id){
        usedCarFiltered = carEJB.findAUsedCar(id);
        return "/Car/foundUsedCar.xhtml";
    }

    //Getters & Setters         
    public Car getNewCar() {
        return newCar;
    }

    public void setNewCar(Car car) {
        this.newCar = car;
    }

    public List<Car> getNewCarList() {
        newCarList = carEJB.findNewCars();
        return newCarList;
    }

    public void setNewCarList(List<Car> carList) {
        this.newCarList = carList;
    }

    /**
     * @return the newCarFiltered
     */
    public List<Car> getNewCarFiltered() {
        return newCarFiltered;
    }

    /**
     * @param newCarFiltered the newCarFiltered to set
     */
    public void setNewCarFiltered(List<Car> newCarFiltered) {
        this.newCarFiltered = newCarFiltered;
    }

    /**
     * @return the usedCar
     */
    public Car getUsedCar() {
        return usedCar;
    }

    /**
     * @param usedCar the usedCar to set
     */
    public void setUsedCar(Car usedCar) {
        this.usedCar = usedCar;
    }

    /**
     * @return the usedCarList
     */
    public List<Car> getUsedCarList() {
        usedCarList = carEJB.findUsedCars();
        return usedCarList;
    }

    /**
     * @param usedCarList the usedCarList to set
     */
    public void setUsedCarList(List<Car> usedCarList) {
        this.usedCarList = usedCarList;
    }

    /**
     * @return the usedCarFiltered
     */
    public List<Car> getUsedCarFiltered() {
        return usedCarFiltered;
    }

    /**
     * @param usedCarFiltered the usedCarFiltered to set
     */
    public void setUsedCarFiltered(List<Car> usedCarFiltered) {
        this.usedCarFiltered = usedCarFiltered;
    }
}
