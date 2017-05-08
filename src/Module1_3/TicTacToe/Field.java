package Module1_3.TicTacToe;

class Field {

    static final String O_MARK = "O";
    static final String X_MARK = "X";

    final int fieldSize = 3;

    private String[][] field = new String[][] {
            {"1", "2", "3"},
            {"4", "5", "6"},
            {"7", "8", "9"}
    };

    private String freeCells = "123456789";

    Field() {
    }

    String getCell(int i, int j) {
        return field[i][j];
    }

    void setCell(int i, int j, String input) {
        field[i][j] = input;
    }

    String getFreeCells() {
        return freeCells;
    }

    boolean isCellFree(String cell) {
        return freeCells.contains(cell);
    }

    void printField() {

        for (int i = 0; i < fieldSize; i++) {

            for (int j = 0; j < fieldSize; j++) {
                System.out.print(" " + field[i][j] + " ");
                if (j == fieldSize - 1) break;
                System.out.print("|");
            }

            System.out.println();
            if (i == fieldSize - 1) break;
            System.out.println("---+---+---");

        }

    }

    void takeUpFreeCell(String cell) {
        if (!freeCells.isEmpty()) freeCells = freeCells.replace(cell,"");
    }
}
