package Module1_3.TicTacToe;

import java.util.Scanner;

public class GameLogic{

    Scanner in = new Scanner(System.in);

    Field field = new Field();
    int movesCount = 0;

    private String getMark() {
        return movesCount % 2 == 1 ? "X" : "O";
    }

    private String getPlayerMove() {

        System.out.print("Your turn, make your move: ");

        String move;

        while (true) {
            move = in.nextLine();
            if (field.isCellFree(move)) break;
            System.out.print("Your move is not correct, try again: ");
        }

        return move;
    }

    private String getPcMove() {

        int randomIndex = (int) (Math.random() * field.getFreeCells().length());
        char move = field.getFreeCells().charAt(randomIndex);

        System.out.println("PC make his move!");

        return String.valueOf(move);

    }

    private void doMove(String move) {

        movesCount++;

        for (int i = 0; i < field.fieldSize; i++) {

            for (int j = 0; j < field.fieldSize; j++) {

                if (move.equals(field.getField()[i][j])) {
                    field.getField()[i][j] = getMark();
                    field.takeUpFreeCell(move);
                    return;
                }

            }

        }

    }

    private boolean isWinner() {

        for (int i = 0; i < field.fieldSize; i++) {

            for (int j = 0; j < field.fieldSize; j++) {
                if (!field.getField()[i][j].equals(getMark())) break;
            }
        }

        return false;
    }

    public void start() {

        field.printField();

        while(true) {

            doMove(getPlayerMove());
            field.printField();
            if (isWinner()) {
                System.out.println("Congratulations, you won!");
                break;
            }
            if (movesCount == 9) {
                System.out.println("It is draw...");
                break;
            }

            doMove(getPcMove());
            field.printField();
            if (isWinner()) {
                System.out.println("Sorry, you loose!");
                break;
            }

        }

        System.out.println("The END!");
        in.close();
    }

}
