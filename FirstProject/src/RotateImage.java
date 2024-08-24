import java.util.Arrays;

public class RotateImage {
    public static void rotate(int[][] matrix) {
        int row = 0;
        int n = matrix.length;
        int[][] copy = new int[n][n];
        for(int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, copy[i], 0, n);
        }
        int col = n - 1;
        while(row < n) {
            int i = 0;
            int j = 0;
            while(i < n) {
                matrix[j++][col] = copy[row][i++];
            }
            row++;
            col--;
        }
    }
    public static void main(String[] args) {
        rotate(new int[][]{{1,2,3}, {4,5,6}, {7,8,9}});
    }

}
