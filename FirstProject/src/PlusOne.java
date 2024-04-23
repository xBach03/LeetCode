public class PlusOne {
    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] == 9 && digits.length == 1){
            return new int[]{1, 0};
        } else if(digits[digits.length - 1] == 9){
            for(int i = digits.length - 1; i >= 0; i--){
                if(digits[i] == 9){
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    return digits;
                }
            }
        }
        digits[digits.length - 1]++;
        return digits;
    }
    public static void main(String[] Args){
        int[] ans = plusOne(new int[]{9, 9});
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + ", ");
        }

    }
}
