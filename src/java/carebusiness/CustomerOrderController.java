/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carebusiness;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ifte
 */
//@Named(value = "customerOrderController")
@ManagedBean(name = "customerOrderController")
@RequestScoped
public class CustomerOrderController {

    //Attributes
    @EJB
    private CustomerOrderEJB customerOrderEJB;
    private CustomerOrder customerOrder = new CustomerOrder();
    private List<CustomerOrder> customerOrderList = new ArrayList<>();
    private List<CustomerOrder> customerOrderFiltered = new ArrayList<>();

    //Public methods           
    public String newCustomerOrderForm() {
        return "createNewCustomerOrder.xhtml";
    }

    public String createNewCustomerOrder() {

        FacesContext ctx = FacesContext.getCurrentInstance();

        try {
            customerOrderEJB.createOrder(customerOrder);
            ctx.addMessage("displayNewCustomerOrderMessage:newCustomerOrderMessage", new FacesMessage(FacesMessage.SEVERITY_INFO, "The new Customer Order has been created", "Successfully created the order for " + customerOrder.getCustomer().getName()));
        } catch (Exception e) {
            ctx.addMessage("displayNewCustomerOrderMessage:newCustomerOrderMessage", new FacesMessage(FacesMessage.SEVERITY_ERROR, "The new Customer Order hasn't been created", "error: " + e.getMessage()));
        }

        return "listOfOrders.xhtml";
    }

    public String searchCustomerOrder(long id) {
        customerOrderFiltered = customerOrderEJB.findOrderById(id);
        //customerOrderList = customerOrderFiltered;
        return "foundCustomerOrder.xhtml";
    }
    
    public List<CustomerOrder> getCustomerFilteredList(long id){
        
        this.customerOrderFiltered = this.getCustomerOrderList();
        for(int i = 0; i < this.customerOrderFiltered.size();i++){
            if(this.customerOrderFiltered.get(i).getId() != id){
                this.customerOrderFiltered.remove(i);
            }
        }
        return customerOrderFiltered;
    }

    //Getters & Setters
    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder order) {
        this.customerOrder = order;
    }

    public List<CustomerOrder> getCustomerOrderList() {
        customerOrderList = customerOrderEJB.findOrders();
        //customerOrder = customerOrderList.get(0);
        return customerOrderList;
    }

    public void getCustomerOrderByCustomerId(long id) {
        customerOrderFiltered = customerOrderEJB.findOrdersByCustomerId(id);

//        return customerOrderFiltered;
    }

    public int getCustomerOrderCount(long id) {
        customerOrderFiltered = customerOrderEJB.findOrdersByCustomerId(id);
        return customerOrderFiltered.size();
    }

    public void setCustomerOrderList(List<CustomerOrder> orderList) {
        this.customerOrderList = orderList;
    }

    public List<CustomerOrder> getCustomerOrderFiltered() {
        //customerOrderFiltered = customerOrderEJB.findOrderById(customerOrder.getId());
        return customerOrderFiltered;
    }

    public void deleteOrder(long id) {
        for (CustomerOrder co : this.getCustomerOrderList()) {
            if (co.getId() == id) {
                customerOrderEJB.deleteOrder(co);
            }
        }
    }

    /**
     * @param customerOrderFiltered the customerOrderFiltered to set
     */
    public void setCustomerOrderFiltered(List<CustomerOrder> customerOrderFiltered) {
        this.customerOrderFiltered = customerOrderFiltered;
    }

}
