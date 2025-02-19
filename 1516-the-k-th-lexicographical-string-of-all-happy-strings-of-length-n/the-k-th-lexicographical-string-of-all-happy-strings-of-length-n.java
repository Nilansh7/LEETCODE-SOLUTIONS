import java.util.*;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> result = new ArrayList<>();
        generateHappyStrings(n, "", result);

        return k <= result.size() ? result.get(k - 1) : "";
    }

    private void generateHappyStrings(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        for (char ch : new char[]{'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                generateHappyStrings(n, current + ch, result);
            }
        }
    }
}
