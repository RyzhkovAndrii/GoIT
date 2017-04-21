package CoffeMachine;

public class CoffeeDrinksHolder {

    private static CoffeeDrink[] coffeeDrinks = new CoffeeDrink[5];

    static {
        coffeeDrinks[0] = new CoffeeDrink("espresso", 600);
        coffeeDrinks[1] = new CoffeeDrink("americano", 700);
        coffeeDrinks[2] = new CoffeeDrink("cappuccino", 800);
        coffeeDrinks[3] = new CoffeeDrink("coffee with milk", 800);
        coffeeDrinks[4] = new CoffeeDrink("latte", 900);
    }

    public static CoffeeDrink[] getCoffeeDrinks() {
        return coffeeDrinks;
    }



}
