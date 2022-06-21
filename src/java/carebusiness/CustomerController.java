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
 * @author Ifte
 */
//@Named(value = "customerController")customerController
@ManagedBean(name = "customerController")
@RequestScoped
public class CustomerController {

    //Attributes             
    @EJB
    private CustomerEJB customerEJB;
    private Customer customer = new Customer();
    private List<Customer> customerList = new ArrayList<>();
    private List<Customer> customerFiltered = new ArrayList<>();

    //Public methods           
    public String newCustomerForm() {
        return "createNewCustomer.xhtml";
    }

    public String createNewCustomer() {
        FacesContext ctx = FacesContext.getCurrentInstance();

        try {
            customer = customerEJB.createNewCustomer(customer);
            ctx.addMessage("displayNewCustomerMessage:newCustomerMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "The new Customer has been created", "Successfully created the customer: " + customer.getName()));
        } catch (Exception e) {
            ctx.addMessage("displayNewCustomerMessage:newCustomerMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The new Customer hasn't been created", e.getMessage()));
        }

        return "listOfCustomer.xhtml";
    }

    public String getCustomerDetails(long id) {
        for (Customer c : this.getCustomerList()) {
            if (c.getId().equals(id)) {
                this.customer = c;
            }
        }

        return "/Customer/customerDetails.xhtml";
    }

//    public String getCustomerDetails(Customer customer) {
//
////        FacesContext ctx = FacesContext.getCurrentInstance();
////
////        try {
////            for (Customer c : this.getCustomerList()) {
////                if (c.equals(customer)) {
////                    this.customer = c;
////                }
////            }
////            ctx.addMessage("displayNewCustomerMessage:newCustomerMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "The new Customer has been created", "Successfully created the customer: " + customer.getName()));
////        } catch (Exception e) {
////            ctx.addMessage("displayNewCustomerMessage:newCustomerMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The new Customer hasn't been created", e.getMessage()));
////        }
//
//        return "/Customer/customerDetails.xhtml";
//    }

    public String searchCustomer() {
        customerFiltered = customerEJB.findACustomer(customer.getName());
        return "foundCustomer.xhtml";
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Customer> getCustomerList() {
        customerList = customerEJB.findCustomers();
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public List<Customer> getCustomerFiltered() {
        return customerFiltered;
    }

    public void setCustomerFiltered(List<Customer> customerFiltered) {
        this.customerFiltered = customerFiltered;
    }
}
