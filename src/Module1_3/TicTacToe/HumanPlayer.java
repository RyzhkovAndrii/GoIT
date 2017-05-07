package Module1_3.TicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player {

    Scanner in = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public String makeMove(Field field) {

        System.out.print("Your turn, make your move: ");

        String move;

        while (true) {
            move = in.nextLine();
            if (field.isCellFree(move)) break;
            System.out.print("Your move is not correct, try again: ");
        }

        return move;
    }
}
