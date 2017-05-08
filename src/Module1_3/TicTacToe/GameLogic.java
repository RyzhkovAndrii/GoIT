package Module1_3.TicTacToe;

public class GameLogic {

    //private Player[] players = {new HumanPlayer("Player1"), new ComputerPlayer()};
    private Player[] players = {new ComputerPlayer(), new ComputerPlayer()};

    private Field field = new Field();

    private int movesCount = 0;
    private int turn;

    private int xMoveCoord;
    private int yMoveCoord;

    private String getMark() {
        return turn == 0 ? "X" : "O";
    }

    private void processMove(Player player) {

        String move = player.makeMove(field);

        for (int i = 0; i < field.fieldSize; i++) {

            for (int j = 0; j < field.fieldSize; j++) {

                if (move.equals(field.getField()[i][j])) {

                    field.getField()[i][j] = getMark();
                    field.takeUpFreeCell(move);

                    xMoveCoord = j;
                    yMoveCoord = i;

                    return;
                }

            }

        }
    }

    private boolean isWinner(Player player) {

        if (movesCount < 5) return false;

        int currentMove = yMoveCoord + xMoveCoord * field.fieldSize + 1;

        boolean isWinHorizontal = true;
        boolean isWinVertical = true;
        boolean isWinMainDiagonal = true;
        boolean isWinSideDiagonal = true;

        /*если ячейка четная, то нужно проверять только ячейки столбца и строки для текущего хода,
        если - нечетная, то также необходимо проверить диагональ, на которой она лежит
        */

        switch (currentMove % 2) {

            case 1: {

                switch (currentMove) {

                    case 5: {

                        for (int i = 0, k = field.fieldSize - 1; i < field.fieldSize; i++, k--) {
                            isWinMainDiagonal &= field.getField()[i][i].equals(getMark());
                            isWinSideDiagonal &= field.getField()[i][k].equals(getMark());
                        }

                        if (isWinMainDiagonal || isWinSideDiagonal) {
                            System.out.println(player.getName() + " is winner!!!");
                            return true;
                        }

                        break;

                    }

                    case 1:
                    case 9: {

                        for (int i = 0; i < field.fieldSize; i++) {
                            isWinMainDiagonal &= field.getField()[i][i].equals(getMark());
                        }

                        if (isWinMainDiagonal) {
                            System.out.println(player.getName() + " is winner!!!");
                            return true;
                        }

                        break;
                    }

                    case 3:
                    case 7: {

                        for (int i = 0, k = field.fieldSize - 1; i < field.fieldSize; i++, k--) {
                            isWinSideDiagonal &= field.getField()[i][k].equals(getMark());
                        }

                        if (isWinSideDiagonal) {
                            System.out.println(player.getName() + " is winner!!!");
                            return true;
                        }

                        break;

                    }

                }

            }

            case 0: {

                for (int i = 0; i < field.fieldSize; i++) {
                    isWinHorizontal &= field.getField()[i][xMoveCoord].equals(getMark());
                    isWinVertical &= field.getField()[yMoveCoord][i].equals(getMark());
                }

                if (isWinHorizontal || isWinVertical) {
                    System.out.println(player.getName() + " is winner!!!");
                    return true;
                }

            }

            default: break;
        }

        return false;
    }

    public void start() {

        field.printField();

        while(true) {

            processMove(players[turn]);
            field.printField();
            if (isWinner(players[turn])) break;

            movesCount++;
            turn = movesCount % 2;

            if (movesCount == 9) {
                System.out.println("It is draw...");
                break;
            }
        }

        System.out.println("The END!");
    }

}
