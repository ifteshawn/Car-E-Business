package carebusiness;

import carebusiness.Car;
import carebusiness.Customer;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2022-06-02T15:04:14")
@StaticMetamodel(CustomerOrder.class)
public class CustomerOrder_ { 

    public static volatile SingularAttribute<CustomerOrder, Double> unitPrice;
    public static volatile SingularAttribute<CustomerOrder, Date> dateCreated;
    public static volatile SingularAttribute<CustomerOrder, Car> car;
    public static volatile SingularAttribute<CustomerOrder, Double> totalPrice;
    public static volatile SingularAttribute<CustomerOrder, Long> id;
    public static volatile SingularAttribute<CustomerOrder, Integer> qtyOfCar;
    public static volatile SingularAttribute<CustomerOrder, Customer> customer;

}