package cafe.customer;

import cafe.drinks.Order;

public class Customer {
    private final String name;
    private final Order order;

    public Customer(String name, Order order) {
        this.name = name;
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public Order getOrder() {
        return order;
    }
}