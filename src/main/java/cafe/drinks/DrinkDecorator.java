package cafe.drinks;

import java.util.Map;

public abstract class DrinkDecorator extends Drink {
    protected final Drink drink;

    protected DrinkDecorator(Drink drink){
        super(drink.temperature(), Map.of() );
        this.drink = drink;
    }

    @Override
    public Temperature temperature() {
        return drink.temperature();
    }

    @Override
    public Map<String, Integer> ingredients() {
        return drink.ingredients();
    }

    @Override
    public String name() {
        return drink.name();
    }

    @Override
    public int basePriceCents() {
        return drink.basePriceCents();
    }
}
