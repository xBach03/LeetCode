import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        int result = 0;
        Arrays.sort(citations);
        int[] calc = new int[citations.length];
        calc[0] = citations.length;
        for(int i = 1; i < calc.length; i++) {
            calc[i] = calc[i] == calc[i - 1] ? calc[i - 1] : citations.length - i;
        }
        for(int i = 0; i < calc.length; i++) {
            if(calc[i] <= citations[i] && calc[i] > result) {
                result = calc[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(hIndex(new int[] {7,7,7,7}));
    }
}
