import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public static String intToRoman(int num) {
        Map<Integer, String> mp = new HashMap<>();
        mp.put(1, "I");
        mp.put(2, "II");
        mp.put(3, "III");
        mp.put(4, "IV");
        mp.put(5, "V");
        mp.put(6, "VI");
        mp.put(7, "VII");
        mp.put(8, "VIII");
        mp.put(9, "IX");
        mp.put(10, "X");
        mp.put(20, "XX");
        mp.put(30, "XXX");
        mp.put(40, "XL");
        mp.put(50, "L");
        mp.put(60, "LX");
        mp.put(70, "LXX");
        mp.put(80, "LXXX");
        mp.put(90, "XC");
        mp.put(100, "C");
        mp.put(200, "CC");
        mp.put(300, "CCC");
        mp.put(400, "CD");
        mp.put(500, "D");
        mp.put(600, "DC");
        mp.put(700, "DCC");
        mp.put(800, "DCCC");
        mp.put(900, "CM");
        mp.put(1000, "M");
        mp.put(2000, "MM");
        mp.put(3000, "MMM");
        int divider = 1000;
        StringBuilder ans = new StringBuilder();
        while(num > 0) {
            int temp = (num / divider) * divider;
            if(temp != 0) ans.append(mp.get(temp));
            num %= divider;
            divider /= 10;
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }
}
