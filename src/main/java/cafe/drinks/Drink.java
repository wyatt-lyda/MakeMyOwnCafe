package cafe.drinks;

import java.util.Map;

public abstract class Drink {
    private final Temperature temperature;
    private final Map<String, Integer> ingredients;

    protected Drink(Temperature temperature, Map<String, Integer> ingredients) {
        this.temperature = temperature;
        this.ingredients = Map.copyOf(ingredients);
    }

    public Temperature temperature() {
        return temperature;
    }

    public Map<String, Integer> ingredients() {
        return ingredients;
    }

    public abstract String name();
    public abstract int basePriceCents();
}