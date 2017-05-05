package Offline1.Task4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MagicMatrix {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/Offline1/Task4/magicMatrix.txt"));

        //System.out.print("Please enter magic matrix size: ");
        int matrixSize = scanner.nextInt();

        int[][] magicMatrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < magicMatrix.length; i++) {
            for (int j = 0; j < magicMatrix[i].length; j++) {
                magicMatrix[i][j] = scanner.nextInt();
            }
        }

        int horizontalSum = 0;
        int verticalSum = 0;
        int mainDiagonalSum = 0;
        int sideDiagonalSum = 0;

        int magicConstant = 0;

        for (int i = 0; i < matrixSize; i++) {
            magicConstant += magicMatrix[0][i];
        }


        for (int i = 0; i < matrixSize; i++) {

            for (int j = 0; j < matrixSize; j++) {
                horizontalSum += magicMatrix[i][j];
                verticalSum += magicMatrix[j][i];
            }

            if (horizontalSum != magicConstant || verticalSum != magicConstant) {
                System.out.println("The matrix is NOT magic!!!");
                return;
            }

            horizontalSum = 0;
            verticalSum = 0;

            mainDiagonalSum += magicMatrix[i][i];
            sideDiagonalSum += magicMatrix[i][matrixSize - i - 1];
        }


        if (mainDiagonalSum != magicConstant || sideDiagonalSum != magicConstant) {
            System.out.println("The matrix is NOT magic!!!");
            return;
        }

        System.out.println("The matrix IS magic!!!");

    }
}
