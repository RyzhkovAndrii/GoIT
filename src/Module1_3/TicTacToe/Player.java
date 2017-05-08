package Module1_3.TicTacToe;

import java.util.Scanner;

public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract String makeMove(Field field, Scanner scanner);

}
