import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.addFirst(1);
        ans.add(firstRow);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(0);
                }
            }

            ans.add(row);
        }
        for (int i = 2; i < numRows; i++) {
            List<Integer> prevRow = ans.get(i - 1);
            List<Integer> currentRow = ans.get(i);
            int prevLeft = 0;
            int prevRight = 1;
            for (int j = 1; j < currentRow.size() - 1; j++) {
                currentRow.set(j, prevRow.get(prevLeft++) + prevRow.get(prevRight++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        PascalTriangle test = new PascalTriangle();
        test.generate(5);
    }
}
