import java.util.HashMap;
import java.util.Map;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        int length = s.length();
        if(numRows == 1 || length == 1 || numRows >= length) return s;
        int diagonal = numRows - 2;
        Map<Integer, StringBuilder> mp = new HashMap<>();
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

            if(mp.containsKey(row)) {
                StringBuilder temp = mp.get(row);
                temp.append(s.charAt(i));
                mp.replace(row, temp);
            } else {
                StringBuilder temp = new StringBuilder();
                temp.append(s.charAt(i));
                mp.put(row, temp);
            }
            if(isInDiagonal) {
                row--;
            } else {
                row++;
            }
        }
        for(int i = 0; i < numRows; i++) {
            ans.append(mp.get(i));
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String s = convert("PAYPALISHIRING", 4);
        System.out.println(s);
    }
}
