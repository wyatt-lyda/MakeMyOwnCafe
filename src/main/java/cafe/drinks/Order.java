package cafe.drinks;

import java.util.Map;

public record Order(
        String drinkType,
        Temperature temperature,
        Map<String, Integer> ingredients
) {
    public Order {
        ingredients = Map.copyOf(ingredients);
    }
}