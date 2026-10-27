# MakeMyOwnCafe
Run your own cafe! Make drinks, fulfill customer orders, and earn points by getting every recipe just right.

## Design Patterns
- Factory Pattern: The customer will be made using a factory pattern which
creates customers with different sorts of attitudes/tastes/budgets 

- Decorator Pattern: Drinks will use a decorator pattern by extending the drink and wrapping it with different shots or toppings to be added 
to the drink, even multiples of the same thing (ie double espresso shot)

- Strategy Pattern: The game scoring will be a strategy pattern, with different scorings going into how something is graded

## Object-Oriented Design

- Coding to abstractions: The game depends on ScoringStrategy rather
  than directly depending on RecipeScoringStrategy. Drink variables
  can hold base drinks or decorated drinks.

- Polymorphism: Calling ingredients() on a Drink variable invokes the
  implementation belonging to its actual object, such as Latte,
  Espresso, Milk, or Vanilla.

- Dependency injection: CafeGame receives its Scoring Strategy through
  its constructor, rather than creating it internally.