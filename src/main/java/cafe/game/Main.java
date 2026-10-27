package cafe.game;

import cafe.drinks.*;
import cafe.scoring.RecipeScoringStrategy;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CafeGame game = new CafeGame(new RecipeScoringStrategy());

        Order order = new Order(
                "Latte",
                Temperature.HOT,
                Map.of("espresso", 1, "milk", 2)
        );

        System.out.println("Welcome to the cafe!");
        System.out.println("Customer order: Hot latte");
        System.out.println("Recipe: 1 espresso, 2 milk");

        Temperature temperature;

        while (true) {
            System.out.println("Choose temperature: 1 = Hot, 2 = Iced");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                temperature = Temperature.HOT;
                break;
            } else if (choice.equals("2")) {
                temperature = Temperature.ICED;
                break;
            } else {
                System.out.println("Please enter 1 or 2.");
            }
        }

        Drink drink = new Latte(temperature, Map.of());
        boolean submitted = false;

        while (!submitted) {
            System.out.println("\nCurrent ingredients: " + drink.ingredients());
            System.out.println("1. Add espresso");
            System.out.println("2. Add milk");
            System.out.println("3. Add vanilla");
            System.out.println("4. Submit drink");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> drink = new Espresso(drink);
                case "2" -> drink = new Milk(drink);
                case "3" -> drink = new Vanilla(drink);
                case "4" -> {
                    int score = game.submit(order, drink);
                    System.out.println("You scored: " + score + "/100");
                    submitted = true;
                }
                default -> System.out.println("Please enter 1, 2, 3, or 4.");
            }
        }
    }
}