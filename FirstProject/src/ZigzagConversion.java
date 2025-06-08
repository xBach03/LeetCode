import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if(numRows == 1 || length == 1 || numRows >= length) return s;
        int diagonal = numRows - 2;
        StringBuilder[] builders = new StringBuilder[numRows];
        StringBuilder ans = new StringBuilder(length);
        int row = 0;
        boolean isInDiagonal = false;
        int loop = numRows + diagonal;
        for(int i = 0; i < length; i++) {
            if(i % loop == 0) {
                row = 0;
                isInDiagonal = false;
            }
            if(row == numRows - 1) {
                isInDiagonal = true;
            }
            if(builders[row] == null) {
                builders[row] = new StringBuilder();
            }
            builders[row].append(s.charAt(i));
            if(isInDiagonal) {
                row--;
            } else {
                row++;
            }
        }
        for(int i = 0; i < numRows; i++) {
            ans.append(builders[i]);
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 4);
        System.out.println(s);
    }
}
