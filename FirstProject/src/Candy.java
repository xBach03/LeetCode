import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Candy {
    public static int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);
        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
            }
        }
        return Arrays.stream(candy).sum();
    }
    public static void main(String[] args) {
        System.out.println(candy(new int[] {29,51,87,87,72,12}));
    }
}
