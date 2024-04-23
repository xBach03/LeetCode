import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int x = a.length() - 1;
        int y = b.length()- 1;
        while(x >= 0 && y >= 0){
            int sum = 0;
            if(x >= 0) sum += a.charAt(x) - '0';
            if(y >= 0) sum += b.charAt(y) - '0';
            carry = sum > 1 ? 1 : 0;
            result.append(sum % 2);
        }
        if(carry != 0) result.append(carry);
        return result.reverse().toString();
    }
}
