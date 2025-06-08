public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        int int1 = 0;
        int int2 = 0;
        int count1 = num1.length() - 1;
        int count2 = num2.length() - 1;
        for(int i = 0; i < num1.length(); i++) {
            int1 += (num1.charAt(i) - '0') * (int)Math.pow(10, count1);
            count1--;
        }
        for(int i = 0; i < num2.length(); i++) {
            int2 += (num2.charAt(i) - '0') * (int)Math.pow(10, count2);
            count2--;
        }
        Integer result = int1 * int2;
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }
}
