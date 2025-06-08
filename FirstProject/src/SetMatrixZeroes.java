import java.util.ArrayList;
import java.util.List;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int i : row) {
            int j = 0;
            while(j < matrix[0].length) {
                matrix[i][j++] = 0;
            }
        }
        for(int i : col) {
            int j = 0;
            while(j < matrix.length) {
                matrix[j++][i] = 0;
            }
        }
    }
}
