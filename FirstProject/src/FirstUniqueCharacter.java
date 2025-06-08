public class FirstUniqueCharacter {
    public static int firstUniqChar(String s) {
        int[] count = new int[26];
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            pos[s.charAt(i) - 'a'] = i;
        }
        int ans = -1;
        int minPos = 1000000;
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1 && pos[i] < minPos) {
                minPos = pos[i];
                ans = pos[i];
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
