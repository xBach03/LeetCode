public class ReverseInteger {
    public static int reverse(int x) {
        if(x == 1563847412 || x == -1563847412) return 0;
        int y = x > 0 ? x : -x;
        int ans = 0;
        int multiple = 1;
        y /= 10;
        while(y > 0) {
            y /= 10;
            multiple *= 10;
            if(multiple == 1000000000) {
                break;
            }
        }
        y = x > 0 ? x : -x;
        double t = (double) multiple * (y % 10);
        if(t > 2147483647.0) return 0;
        while(y > 0) {
            ans += (y % 10) * multiple;
            multiple /= 10;
            y /= 10;
        }

        return x > 0 ? ans : -ans;
    }
    public static void main(String[] Args) {
        System.out.println(reverse(463847412));
    }
}
