public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
        if(x < 0) return false;
        int pow = 10;
        int y = x;
        int z = y % 10;
        y /= 10;
        while(y > 0) {
            z = (z * pow) + (y % 10);
            y /= 10;
        }
        return z == x;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome(121));
    }
}
