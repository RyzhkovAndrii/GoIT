package Module1_3.TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    HumanPlayer(String name, String mark) {
        super(name, mark);
    }

    @Override
    String makeMove(Field field, Scanner scanner) {

        if (field.getFreeCells().length() == 1) {
            System.out.println(getName() + " your last move is \"" + field.getFreeCells() + "\"");
            return field.getFreeCells();
        }

        System.out.print(getName() + ", please make your move: ");

        while (true) {
            String move = scanner.nextLine();
            if (!move.isEmpty() && field.isCellFree(move))  return move;
            System.out.print("Your move is not correct, try again: ");
        }
    }
}
