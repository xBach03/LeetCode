
import java.util.ArrayList;
import java.util.Arrays;

public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        if(piles.length == 1) {
            if(piles[0] % h != 0) {
                return (piles[0] / h) + 1;
            } else {
                return (piles[0] / h);
            }
        }

        int left = 1;
        int right = 1000000000;
        ArrayList<Integer> list = new ArrayList<>();
        while(left <= right) {
            int mid = (left + right) / 2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++) {
                hours += Math.ceil((double) piles[i] / mid);
            }
            if(hours == h) {
                list.add(mid);
                right = mid - 1;
            } else if(hours > h) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return list.isEmpty() ? right + 1 : list.getLast();
    }
    public static void main(String[] Args) {
        int[] piles = new int[] {332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184};
        int h = 823855818;
        System.out.println(minEatingSpeed(piles, h));
    }
}
