package cafe.factory;

import cafe.customer.Customer;
import cafe.drinks.Order;
import cafe.drinks.Temperature;

import java.util.Map;

public final class CustomerFactory {
    private CustomerFactory() {
    }

    public static Customer create(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Customer type cannot be null");
        }

        return switch (type.toLowerCase()) {
            case "regular" -> new Customer(
                    "Alex",
                    new Order(
                            "Latte",
                            Temperature.HOT,
                            Map.of("espresso", 1, "milk", 2)
                    )
            );

            case "vanilla" -> new Customer(
                    "Sam",
                    new Order(
                            "Latte",
                            Temperature.ICED,
                            Map.of("espresso", 1, "milk", 2, "vanilla", 1)
                    )
            );

            default -> throw new IllegalArgumentException(
                    "Unknown customer type: " + type
            );
        };
    }
}