public class ReverseString {
    public static void reverseString(char[] s) {
        int n = s.length;
        int length = s.length;
        int i = 0;
        while(i < length / 2) {
            char temp = s[i];
            s[i] = s[n - 1];
            s[n - 1] = temp;
            i++;
            n--;
        }
    }
    public static void main(String[] Args) {
        char[] s = new char[] {'h', 'e','l', 'l', 'o'};
        reverseString(s);
        for(char x : s) {
            System.out.println(x);
        }
    }
}
