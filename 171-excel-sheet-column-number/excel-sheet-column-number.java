class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            int value = ch - 'A' + 1; // Convert 'A' to 1, 'B' to 2, ..., 'Z' to 26
            result = result * 26 + value;
        }

        return result;
    }
}
