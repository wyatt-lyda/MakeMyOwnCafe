package cafe.drinks;

import cafe.drinks.Temperature;
import cafe.game.CafeGame;
import cafe.scoring.RecipeScoringStrategy;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrinkDecoratorTest {

    @Test
    void ingredientsAccumulateThroughDecorators() {
        // Uses the first temperature in your existing enum.
        Temperature temperature = Temperature.values()[0];

        Drink drink = new Latte(temperature, Map.of());
        drink = new Espresso(drink);
        drink = new Milk(drink);
        drink = new Milk(drink);
        drink = new Vanilla(drink);

        assertEquals(
                Map.of("espresso", 1, "milk", 2, "vanilla", 1),
                drink.ingredients()
        );
        assertEquals("Latte", drink.name());
        assertEquals(temperature, drink.temperature());
    }

    @Test
    void matchingDrinkGetsFullScore() {
        Temperature temperature = Temperature.values()[0];

        Order order = new Order(
                "Latte",
                temperature,
                Map.of("espresso", 1, "milk", 2)
        );

        Drink drink = new Latte(temperature, Map.of());
        drink = new Espresso(drink);
        drink = new Milk(drink);
        drink = new Milk(drink);

        CafeGame game = new CafeGame(new RecipeScoringStrategy());

        assertEquals(100, game.submit(order, drink));
    }
}