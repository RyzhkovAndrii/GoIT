package Module1_3.TicTacToe;

public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeMove(Field field);

}
