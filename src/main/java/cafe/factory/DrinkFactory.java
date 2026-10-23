package cafe.factory;

import cafe.drinks.Drink;
import cafe.drinks.Latte;
import cafe.drinks.Temperature;

import java.util.Map;

public final class DrinkFactory {
    private DrinkFactory() {
    }

    public static Drink create(
            String type,
            Temperature temperature,
            Map<String, Integer> ingredients
    ) {
        if (type == null) {
            throw new IllegalArgumentException("Drink type cannot be null");
        }

        return switch (type.toLowerCase()) {
            case "latte" -> new Latte(temperature, ingredients);
            default -> throw new IllegalArgumentException(
                    "Unknown drink type: " + type
            );
        };
    }
}