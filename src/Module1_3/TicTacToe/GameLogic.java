package Module1_3.TicTacToe;

public class GameLogic {

    Player[] players = {new HumanPlayer("Player1"), new ComputerPlayer()};

    Field field = new Field();

    int movesCount = 0;
    int turn;

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
                    return;
                }

            }

        }
    }

    private boolean isWinner(Player player) {

        for (int i = 0; i < field.fieldSize; i++) {

            int markCount = 0;

            for (int j = 0; j < field.fieldSize; j++) {

                if (field.getField()[i][j].equals(getMark())) {
                    markCount++;
                } else {
                    markCount = 0;
                    break;
                }

            }

            if (markCount == 3) {
                System.out.println(player.getName() + " is winner!!!");
                return true;
            }

            markCount = 0;

            for (int j = 0; j < field.fieldSize; j++) {

                if (field.getField()[j][i].equals(getMark())) {
                    markCount++;
                } else {
                    markCount = 0;
                    break;
                }

            }

            if (markCount == 3) {
                System.out.println(player.getName() + " is winner!!!");
                return true;
            }
        }

        int markCount = 0;

        for (int i = 0; i < field.fieldSize ; i++) {
            if (field.getField()[i][i].equals(getMark())) {
                 markCount++;
            } else {
                markCount = 0;
                break;
            }
        }

        if (markCount == 3) {
            System.out.println(player.getName() + " is winner!!!");
            return true;
        }

        markCount = 0;

        for (int i = 0, k = field.fieldSize - 1; i < field.fieldSize ; i++, k--) {
            if (field.getField()[i][k].equals(getMark())) {
                markCount++;
            } else {
                markCount = 0;
                break;
            }
        }

        if (markCount == 3) {
            System.out.println(player.getName() + " is winner!!!");
            return true;
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
