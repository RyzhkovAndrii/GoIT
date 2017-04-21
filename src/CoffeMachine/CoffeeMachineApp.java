package CoffeMachine;

import PriceTask.PriceParser;
import java.util.Scanner;

public class CoffeeMachineApp {

    public static void main(String[] args) {

        int money;
        CoffeeDrink[] coffees = CoffeeDrinksHolder.getCoffeeDrinks();

        System.out.println("Input your money:");
        Scanner sc = new Scanner(System.in);
        money = PriceParser.setPrice(sc.nextLine());
        while (money < 600) {
            System.out.println("We need more money:");
            money += PriceParser.setPrice(sc.nextLine());
        }
        sc.close();

        for (CoffeeDrink coffee: coffees) {
            if (coffee.getCost() <= money) {
                System.out.print(coffee.getName());
                System.out.println(", your change is " + PriceParser.getStringPrice(money - coffee.getCost()));
            }
        }
    }

}
