import java.util.Arrays;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int[] copy = nums;
        Arrays.sort(copy);
        for(int i = 0; i < copy.length - 1; i++) {
            if(copy[i] == copy[i + 1]) {
                return copy[i];
            }
        }
        return -1;
    }
    public static void main(String[] Args) {
        System.out.println(findDuplicate(new int[]{3,1,3,4,2}));
    }
}
