public class ExcelSheet {
    public static int titleToNumber(String columnTitle) {
        int[] number = new int[26];
        for(int i = 0; i < 26; i++) {
            number[i] = i  + 1;
        }
        if(columnTitle.length() == 1) {
            return number[columnTitle.charAt(0) - 'A'];
        }
        int result = 0;
        int j = columnTitle.length();
        for(int i = 0; i < columnTitle.length() - 1; i++) {
            result += (int) Math.pow(26, j - 1- i) * number[columnTitle.charAt(i) - 'A'];
        }
        result += number[columnTitle.charAt(columnTitle.length() - 1) - 'A'];
        return result;
    }
    public static void main(String[] Args) {
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
