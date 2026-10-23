package cafe.factory;

import cafe.drinks.Drink;
import cafe.drinks.Latte;
import cafe.drinks.Temperature;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DrinkFactoryTest {
    @Test
    void createsLatte() {
        Drink drink = DrinkFactory.create(
                "latte",
                Temperature.HOT,
                Map.of("espresso", 30, "milk", 180)
        );

        assertInstanceOf(Latte.class, drink);
        assertEquals(Temperature.HOT, drink.temperature());
        assertEquals(30, drink.ingredients().get("espresso"));
    }

    @Test
    void rejectsUnknownDrinkType() {
        assertThrows(IllegalArgumentException.class, () ->
                DrinkFactory.create("mocha", Temperature.HOT, Map.of())
        );
    }

    @Test
    void rejectsNullDrinkType() {
        assertThrows(IllegalArgumentException.class, () ->
                DrinkFactory.create(null, Temperature.HOT, Map.of())
        );
    }
}