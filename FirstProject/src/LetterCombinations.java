import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class LetterCombinations {
    Map<Character, List<String>> keyPad;
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return new ArrayList<>();
        keyPad = new HashMap<>();
        keyPad.put('2', List.of("a", "b", "c"));
        keyPad.put('3', List.of("d", "e", "f"));
        keyPad.put('4', List.of("g", "h", "i"));
        keyPad.put('5', List.of("j", "k", "l"));
        keyPad.put('6', List.of("m", "n", "o"));
        keyPad.put('7', List.of("p", "q", "r", "s"));
        keyPad.put('8', List.of("t", "u", "v"));
        keyPad.put('9', List.of("w", "x", "y", "z"));
        List<StringBuilder> current = new ArrayList<>();
        current.add(new StringBuilder());
        for (int i = 0; i < digits.length(); i++) {
            combine(current, digits.charAt(i));
        }
        List<String> ans = new ArrayList<>();
        for (StringBuilder x : current) {
            if (x.length() == digits.length()) {
                ans.add(x.toString());
            }
        }
        return ans;
    }
    public void combine(List<StringBuilder> current, char key) {
        List<String> values = keyPad.get(key);
        int count = current.size();
        for (int i = 0; i < count; i++) {
            for (String value : values) {
                StringBuilder tmp = new StringBuilder(current.get(i));
                current.add(tmp.append(value));
            }
        }
    }

    public static void main(String[] args) {
        LetterCombinations test = new LetterCombinations();
        test.letterCombinations("23");
    }
}
