package cafe.drinks;

import java.util.Map;

public final class Latte extends Drink {
    public Latte(Temperature temperature, Map<String, Integer> ingredients) {
        super(temperature, ingredients);
    }

    @Override
    public String name() {
        return "Latte";
    }

    @Override
    public int basePriceCents() {
        return 450;
    }
}