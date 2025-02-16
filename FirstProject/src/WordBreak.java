import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        wordDict.sort(Comparator.comparingInt(String::length));
        String cp = new String(s);
        for (String temp : wordDict) {
            String current;
            current = s.replace(temp, "");
            if (wordDict.contains(s.replace(current, ""))) {
                s = s.replace(temp, "");
            }
        }
        for (int i = wordDict.size() - 1; i >= 0; i--) {
            cp = cp.replace(wordDict.get(i), "");
        }
        return s.isEmpty() || cp.isEmpty();
    }

    public static void main(String[] args) {
        WordBreak test = new WordBreak();
        List<String> dict = new ArrayList<>();
        dict.add("bc");
        dict.add("ca");
        System.out.println(test.wordBreak("cbca", dict));
    }
}
