
package Model;

import java.util.HashMap;
import java.util.Map;

public class Order {
    String customer;
    Map<Fruit,Integer> order = new HashMap<>();

    public Order() {
    }

    public Order(String customer, Map<Fruit,Integer> order) {
        this.customer = customer;
        this.order = order;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map<Fruit, Integer> getOrder() {
        return order;
    }

    public void setOrder(Map<Fruit, Integer> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return customer + "," + order;
    }
}