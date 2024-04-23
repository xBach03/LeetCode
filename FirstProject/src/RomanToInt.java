import java.util.HashMap;

public class RomanToInt {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        for(int i = 0; i < s.length(); i++){
            if(i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))){
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }
    public static void main(String[] Args){
        System.out.println(romanToInt("MCMXCIV"));
    }
}
