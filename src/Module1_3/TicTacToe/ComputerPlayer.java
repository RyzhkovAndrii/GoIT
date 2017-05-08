package Module1_3.TicTacToe;

import java.util.Scanner;

public class ComputerPlayer extends Player {


    public ComputerPlayer(String name, String mark) {
        super(name, mark);
    }

    public ComputerPlayer(String mark) {
        super("Computer", mark);
    }

    public ComputerPlayer() {
        super("Computer", Field.O_MARK);
    }

    @Override
    public String makeMove(Field field, Scanner scanner) {

        int randomIndex = (int) (Math.random() * field.getFreeCells().length());
        char move = field.getFreeCells().charAt(randomIndex);

        System.out.println("Computer make his move: \"" + move + "\"");

        return String.valueOf(move);
    }
}
