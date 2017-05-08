package Module1_3.TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String makeMove(Field field, Scanner scanner) {

        System.out.print(getName() + ", please make your move: ");

        while (true) {
            String move = scanner.nextLine();
            if (!move.isEmpty() && field.isCellFree(move))  return move;
            System.out.print("Your move is not correct, try again: ");
        }
    }
}
