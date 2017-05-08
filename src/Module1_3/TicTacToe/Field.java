package Module1_3.TicTacToe;

public class Field {

    public static final String O_MARK = "O";
    public static final String X_MARK = "X";

    private String[][] field;
    private String freeCells;
    public final int fieldSize = 3;

    public Field() {
        this.field = new String[][] {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        freeCells = "123456789";
    }

    public String[][] getField() {
        return field;
    }

    public String getFreeCells() {
        return freeCells;
    }

    public boolean isCellFree(String cell) {
        return freeCells.contains(cell);
    }

    public void printField() {

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

    public void takeUpFreeCell(String cell) {
        if (!freeCells.isEmpty()) freeCells = freeCells.replace(cell,"");
    }
}
