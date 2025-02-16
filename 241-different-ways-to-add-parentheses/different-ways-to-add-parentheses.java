import java.util.*;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        return compute(expression, new HashMap<>());
    }

    private List<Integer> compute(String expression, Map<String, List<Integer>> memo) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> result = new ArrayList<>();
        boolean isNumber = true;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                isNumber = false;

                List<Integer> left = compute(expression.substring(0, i), memo);
                List<Integer> right = compute(expression.substring(i + 1), memo);
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') result.add(l + r);
                        else if (c == '-') result.add(l - r);
                        else if (c == '*') result.add(l * r);
                    }
                }
            }
        }
        if (isNumber) {
            result.add(Integer.parseInt(expression));
        }
        memo.put(expression, result);
        return result;
    }
}
