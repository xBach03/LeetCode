public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while(true) {
            if(target - numbers[i] > numbers[j]) {
                i++;
                continue;
            } else if(target - numbers[i] < numbers[j]) {
                j--;
                continue;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
    }
    public static void main(String[] Args) {
        for(int j : twoSum(new int[]{2, 7, 11, 15}, 9)){
            System.out.println(j);
        }
    }
}
