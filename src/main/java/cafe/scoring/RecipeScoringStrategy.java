package cafe.scoring;

import cafe.drinks.Drink;
import cafe.drinks.Order;

public final class RecipeScoringStrategy implements ScoringStrategy {
    @Override
    public int score(Order order, Drink drink) {
        int score = 0;

        if (order.drinkType().equalsIgnoreCase(drink.name())) score += 40;
        if (order.temperature() == drink.temperature()) score += 20;

        for (var ingredient : order.ingredients().entrySet()) {
            int requested = ingredient.getValue();
            int made = drink.ingredients().getOrDefault(ingredient.getKey(), 0);

            if (requested == made) {
                score += 40 / Math.max(1, order.ingredients().size());
            }
        }

        return Math.min(score, 100);
    }
}