package Module1_3.TicTacToe;

import java.util.Scanner;

public abstract class Player {

    private String name;
    private String mark;

    public Player(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public String getMark() {
        return mark;
    }

    public abstract String makeMove(Field field, Scanner scanner);

}
