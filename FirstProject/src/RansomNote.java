public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] aCount = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            aCount[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++) {
            aCount[ransomNote.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(aCount[i] < 0) {
                return false;
            }
        }
        return true;
    }
}
