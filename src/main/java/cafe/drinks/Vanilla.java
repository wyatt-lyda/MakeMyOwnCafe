package cafe.drinks;

import java.util.HashMap;
import java.util.Map;

public final class Vanilla extends DrinkDecorator {
    public Vanilla(Drink drink) {
        super(drink);
    }

    @Override
    public Map<String, Integer> ingredients() {
        Map<String, Integer> ingredients =
                new HashMap<>(super.ingredients());

        ingredients.merge("vanilla", 1, Integer::sum);

        return Map.copyOf(ingredients);
    }
}