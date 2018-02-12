import java.util.ArrayList;

public class Ch1Q8ZeroMatrix {
    /*Write an algorithm such that if an element in an MxN matrix is 0, every
    element in it's row and column are 0;
    Example:
    Input:      1 2 3 4 5
                1 2 3 4 5
                1 0 3 4 5
                1 2 3 4 5
                1 2 3 4 5
                1 2 0 4 5
                1 2 3 4 5

    Output:     1 0 0 4 5
                1 0 0 4 5
                0 0 0 0 0
                1 0 0 4 5
                1 0 0 4 5
                0 0 0 0 0
                1 0 0 4 5

     */

    public static int[][] buildMatrix() {
        int[][] matrix = {{1,2,3,4,5},{1,2,3,4,5},{1,0,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,0,4,5},{1,2,3,4,5}};
        return matrix;
    }

    public static int[][] getZeroLocations(int[][] matrix) {
        ArrayList<int[]> zeroLocations = new ArrayList<>();

        for(int length = 0;length<matrix.length;length++) {
            for(int width=0;width<matrix[0].length;width++) {
                if(matrix[length][width] == 0) {
                    int[] newArray = new int[2];
                    newArray[0] = length;
                    newArray[1] = width;
                    zeroLocations.add(newArray);
                }
            }
        }
        int[][] zeroLocationsArray = zeroLocations.toArray(new int[zeroLocations.size()][2]);
        return zeroLocationsArray;
    }

    public static void printMatrix(int[][] matrix) {
        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                System.out.printf("%s ", Integer.toString(matrix[i][j]));
            }
            System.out.println();
        }
    }

    public static int[][] zeroRowsAndColumns(int[][] matrix, int[][] zeroLocations) {
        int[] rows = new int[zeroLocations.length];
        int[] columns = new int[zeroLocations.length];
        boolean isInRows = false;
        boolean isInColumns = false;

        for(int i=0;i<zeroLocations.length;i++) {
            rows[i] = zeroLocations[i][0];
            columns[i] = zeroLocations[i][1];
        }

        for(int i=0;i<matrix.length;i++) {
            for(int j=0;j<matrix[0].length;j++) {
                for(int k=0;k<rows.length;k++) {
                    if(i == rows[k]) {
                        matrix[i][j] = 0;
                    }
                    if(j == columns[k]) {
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = buildMatrix();
        int[][] zeroLocationsArray = getZeroLocations(matrix);
        int[][] zeroedMatrix = zeroRowsAndColumns(matrix, zeroLocationsArray);
        printMatrix(zeroedMatrix);
    }
}
