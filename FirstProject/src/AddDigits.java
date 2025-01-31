public class AddDigits {
    public int addDigits(int num) {
        int result = 0;
        if (num < 10) return num;
        while (num > 0) {
            result += num % 10;
            num /= 10;
        }
        if (result % 9 == 0) return 9;
        return result % 9;
    }
}
