package cafe.factory;

import cafe.customer.Customer;
import cafe.drinks.Temperature;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerFactoryTest {

    @Test
    void createsRegularCustomerWithCorrectOrder() {
        Customer customer = CustomerFactory.create("regular");

        assertEquals("Alex", customer.getName());
        assertEquals("Latte", customer.getOrder().drinkType());
        assertEquals(Temperature.HOT, customer.getOrder().temperature());
        assertEquals(
                Map.of("espresso", 1, "milk", 2),
                customer.getOrder().ingredients()
        );
    }

    @Test
    void createsVanillaCustomerWithCorrectOrder() {
        Customer customer = CustomerFactory.create("vanilla");

        assertEquals("Sam", customer.getName());
        assertEquals("Latte", customer.getOrder().drinkType());
        assertEquals(Temperature.ICED, customer.getOrder().temperature());
        assertEquals(
                Map.of("espresso", 1, "milk", 2, "vanilla", 1),
                customer.getOrder().ingredients()
        );
    }

    @Test
    void acceptsUppercaseCustomerType() {
        Customer customer = CustomerFactory.create("REGULAR");

        assertEquals("Alex", customer.getName());
    }

    @Test
    void rejectsUnknownCustomerType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CustomerFactory.create("unknown")
        );
    }

    @Test
    void rejectsNullCustomerType() {
        assertThrows(
                IllegalArgumentException.class,
                () -> CustomerFactory.create(null)
        );
    }
}