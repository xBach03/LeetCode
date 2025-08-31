public class JumpGame {
    public static boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        boolean[] canReach = new boolean[nums.length];
        canReach[0] = nums[0] > 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while(canReach[i] && temp > 0) {
                if (i + temp < nums.length) {
                    canReach[i + temp] = true;
                }
                temp--;
            }
        }
        return canReach[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {2, 0}));
    }
}
