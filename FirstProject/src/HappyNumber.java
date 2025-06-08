import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true) {
            int sum = 0;
            while(n > 0) {
                int x = n % 10;
                sum += x * x;
                n /= 10;
            }
            if(sum == 1) return true;
            else if(set.contains(sum)) {
                return false;
            }
            n = sum;
            set.add(sum);
        }
    }
    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}
