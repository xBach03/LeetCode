import java.util.ArrayList;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex == 0) {
            return List.of(1);
        }
        if (rowIndex == 1) {
            return List.of(1, 1);
        }
        List<List<Integer>> triangle = new ArrayList<>(rowIndex + 1);
        triangle.add(List.of(1));
        triangle.add(List.of(1, 1));
        for (int i = 2; i < rowIndex + 1; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(0);
                }
            }
            triangle.add(row);
        }
        for (int i = 2; i < rowIndex + 1; i++) {
            List<Integer> prevRow = triangle.get(i - 1);
            List<Integer> row = triangle.get(i);
            for (int j = 1; j < i; j++) {
                row.set(j, prevRow.get(j - 1) + prevRow.get(j));
            }
        }
        return triangle.get(rowIndex);
    }
    public static void main(String[] args) {
        PascalTriangleII test = new PascalTriangleII();
        for (int i : test.getRow(3)) {
            System.out.printf(i + " ");
        }
    }
}
