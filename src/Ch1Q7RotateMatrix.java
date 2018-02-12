import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class Ch1Q7RotateMatrix {
    /*Given an image represented by an NxN matrix, where each pixel in the image is 4 ints,
    write a method to rotate the method by 90 degrees.
    BONUS: Can you do this in place?
    */

    public static int[][] buildMatrix(int n) {
        int[][] matrix = new int[n][n];
        String tmpString = " ";

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = i+j;
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix.length;j++) {
                System.out.printf("%s", Integer.toString(matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static int[][] rotateRight90(int[][] matrix) {
        for(int layer=0;layer<matrix.length/2;layer++) {
            int first = layer;
            int last = matrix.length-1-layer;
            for(int i=first;i<last;i++) {
                int offset = i-first;

                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset]=matrix[i][last];
                matrix[i][last]=top;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = buildMatrix(4);
        printMatrix(matrix);

        System.out.println();

        int[][] rotatedMatrix = rotateRight90(matrix);
        printMatrix(rotatedMatrix);
    }
}
