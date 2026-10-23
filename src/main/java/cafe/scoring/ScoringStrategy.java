package cafe.scoring;

import cafe.drinks.Drink;
import cafe.drinks.Order;

public interface ScoringStrategy {
    int score(Order order, Drink drink);
}