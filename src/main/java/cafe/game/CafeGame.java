package cafe.game;

import cafe.drinks.Drink;
import cafe.drinks.Order;
import cafe.scoring.ScoringStrategy;

public final class CafeGame {
    private final ScoringStrategy scoringStrategy;

    public CafeGame(ScoringStrategy scoringStrategy) {
        this.scoringStrategy = scoringStrategy;
    }

    public int submit(Order order, Drink drink) {
        return scoringStrategy.score(order, drink);
    }
}