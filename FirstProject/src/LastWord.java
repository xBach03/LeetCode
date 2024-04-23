public class LastWord {
    public static int LengthOfLastWord(String s) {
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--){

            if(s.charAt(i) != ' '){
                length++;
            } else if(s.charAt(i) == ' ' && length > 0){
                break;
            }
        }
        return length;
    }
    public static void main (String[] Args){
        System.out.println(LengthOfLastWord(" luffy is still joyboy"));
    }
}
