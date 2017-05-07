package Module1_3.TicTacToe;

public class ComputerPlayer extends Player {


    public ComputerPlayer() {
        super("Computer");
    }

    @Override
    public String makeMove(Field field) {

        int randomIndex = (int) (Math.random() * field.getFreeCells().length());
        char move = field.getFreeCells().charAt(randomIndex);

        System.out.println("PC make his move!");

        return String.valueOf(move);
    }
}
