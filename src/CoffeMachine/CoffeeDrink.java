package CoffeMachine;

public class CoffeeDrink {

    private String name;
    private int cost;

    public CoffeeDrink(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public int getCost() {
        return cost;
    }
}
