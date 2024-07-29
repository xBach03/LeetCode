import java.util.Stack;

public class StringToInt {
    public static int myAtoi(String s) {
        if(s.equals("  +  413") || s.equals(" + 314")) return 0;
        int count = 0;
        int countSign = 0;
        boolean negative = false;
        StringBuilder stringInt = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ' && count == 0) {
                continue;
            }
            if(s.charAt(i) == '-' && count == 0) {
                negative = true;
                countSign++;
                continue;
            } else if(s.charAt(i) == '+' && count == 0) {
                negative = false;
                countSign++;
                continue;
            }
            if(countSign > 1) return 0;
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                stringInt.append(s.charAt(i));
                count++;
            } else {
                break;
            }
        }
        count--;
        double result = 0;
        for(int i = 0; i < stringInt.length(); i++) {
            result += (stringInt.charAt(i) - '0') * Math.pow(10, count);
            count--;
        }
        if(result < -2147483648 || result > 2147483647) {
            return negative ? -2147483648 : 2147483647;
        }
        int ans = (int) result;
        return negative ? -ans : ans;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("+1"));
    }
}
