import java.util.*;
import java.util.Arrays;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            char[] test = strs[i].toCharArray();
            Arrays.sort(test);
            String test1 = Arrays.toString(test);
            if(!map.containsKey(test1)){
                map.put(test1, new ArrayList<>());
            }
            map.get(test1).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }
}
