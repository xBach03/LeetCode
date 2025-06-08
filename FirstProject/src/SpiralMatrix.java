import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int m = 0;
        int n = 0;
        int curl = matrix.length * matrix[0].length;
        int colEnd = matrix[0].length;
        int rowEnd = matrix.length;
        int colStart = 0;
        int rowStart = 0;
        boolean rev = false;
        while(curl > 0) {
            if(!rev) {
                while(n < colEnd) {
                    ans.add(matrix[m][n++]);
                    curl--;
                }
                n--;
                m++;
                colEnd--;
                while(m < rowEnd) {
                    ans.add(matrix[m++][n]);
                    curl--;
                }
                m--;
                n--;
                rowEnd--;
                rev = true;
            } else {
                while(n >= colStart) {
                    ans.add(matrix[m][n--]);
                    curl--;
                }
                n++;
                m--;
                colStart++;
                rowStart++;
                while(m >= rowStart) {
                    ans.add(matrix[m--][n]);
                    curl--;
                }
                m++;
                n++;
                rev = false;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        List<Integer> result = spiralOrder(new int[][] {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}
