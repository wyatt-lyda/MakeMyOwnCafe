package cafe.drinks;

import java.util.HashMap;
import java.util.Map;

public final class Milk extends DrinkDecorator {
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public Map<String, Integer> ingredients() {
        Map<String, Integer> ingredients =
                new HashMap<>(super.ingredients());

        ingredients.merge("milk", 1, Integer::sum);

        return Map.copyOf(ingredients);
    }
}