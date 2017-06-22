package Module1_3.TicTacToe;

import java.util.Scanner;

class GameLogic {

    private Player[] players = new Player[2];

    private Field field = new Field();

    private int movesCount = 0;
    private int turn = 0;

    private int moveCoordinateHorizontal;
    private int moveCoordinateVertical;

    private Scanner scanner = new Scanner(System.in);

    private void initGame() {

        players[0] = new HumanPlayer("Player 1", Field.X_MARK);

        System.out.print("Choose number of players (1 or 2): ");

        while (true) {

            switch (scanner.nextLine()) {
                case "1":
                    players[1] = new ComputerPlayer();
                    return;
                case "2":
                    players[1] = new HumanPlayer("Player 2", Field.O_MARK);
                    return;
                default:
                    System.out.print("Your choose is not correct, try again: ");
                    break;
            }

        }
    }

    private void processMove(Player player) {

        String move = player.makeMove(field, scanner);

        for (int i = 0; i < field.fieldSize; i++) {

            for (int j = 0; j < field.fieldSize; j++) {

                if (move.equals(field.getCell(i, j))) {

                    field.setCell(i, j, player.getMark());
                    field.takeUpFreeCell(move);

                    moveCoordinateHorizontal = i;
                    moveCoordinateVertical = j;

                    return;
                }

            }

        }
    }



    private boolean isWinner(Player player) {
        if (movesCount < 4) return false;

        int currentMove = moveCoordinateHorizontal + moveCoordinateVertical * field.fieldSize + 1;
        switch (currentMove % 2) {
            case 1:
                switch (currentMove) {
                    case 5:
                        if (isWinMainDiagonal(player.getMark())
                                || isWinSideDiagonal(player.getMark())) {
                            return true;
                        }
                        break;
                    case 1:
                    case 9:
                        if (isWinMainDiagonal(player.getMark())) {
                            return true;
                        }
                        break;
                    case 3:
                    case 7:
                        if (isWinSideDiagonal(player.getMark())) {
                            return true;
                        }
                        break;
                    default:
                        break;
                }
                /*falls through*/

            case 0:
                if (isWinHorizontal(player.getMark())
                        || isWinVertical(player.getMark())) {
                    return true;
                }
                break;

            default:
                break;

        }

        return false;
    }

    private boolean isWinMainDiagonal(String mark) {
        for (int i = 0; i < field.fieldSize; i++) {
            if (!field.getCell(i, i).equals(mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinSideDiagonal(String mark) {
        for (int i = 0, k = field.fieldSize - 1; i < field.fieldSize; i++, k--) {
            if (!field.getCell(i, k).equals(mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinHorizontal(String mark) {
        for (int i = 0; i < field.fieldSize; i++) {
            if (!field.getCell(i, moveCoordinateVertical).equals(mark)) {
                return false;
            }
        }
        return true;
    }

    private boolean isWinVertical(String mark) {
        for (int i = 0; i < field.fieldSize; i++) {
            if (!field.getCell(moveCoordinateHorizontal, i).equals(mark)) {
                return false;
            }
        }
        return true;
    }

    void start() {
        initGame();
        field.printField();

        while(true) {
            processMove(players[turn]);
            field.printField();
            if (isWinner(players[turn])) {
                System.out.println(players[turn].getName() + " is winner!!!");
                break;
            }
            movesCount++;
            turn = movesCount % 2;
            if (movesCount == 9) {
                System.out.println("It is draw...");
                break;
            }
        }
        scanner.close();
    }

}
