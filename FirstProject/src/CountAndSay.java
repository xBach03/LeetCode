public class CountAndSay {
    public static String countAndSay(int n) {
        String[] ans = new String[n + 1];
        String[] counter = new String[] {"", "1", "2", "3"};
        ans[1] = "1";
        ans[2] = "11";
        if (n < 3) {
            return ans[n];
        }
        for (int i = 3; i < n + 1; i++) {
            String temp = ans [i - 1];
            StringBuilder current = new StringBuilder();
            int count = 1;
            int j = 0;
            for (j = 0; j < temp.length() - 1; j++) {
                if (temp.charAt(j) != temp.charAt(j + 1)) {
                    current.append(counter[count]).append(temp.charAt(j));
                    count = 1;
                } else {
                    count++;
                }
            }
            current.append(counter[count]).append(temp.charAt(j));
            ans[i] = current.toString();
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }
}
