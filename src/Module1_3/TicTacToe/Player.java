package Module1_3.TicTacToe;

import java.util.Scanner;

abstract class Player {

    private String name;
    private String mark;

    Player(String name, String mark) {
        this.name = name;
        this.mark = mark;
    }

    String getName() {
        return name;
    }

    String getMark() {
        return mark;
    }

    abstract String makeMove(Field field, Scanner scanner);

}
