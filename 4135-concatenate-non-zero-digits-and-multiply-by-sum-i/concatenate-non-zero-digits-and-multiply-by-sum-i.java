class Solution {
    public long sumAndMultiply(int n) {
        long num1 = 0;
        long num2 = 0;
        for (char word : String.valueOf(n).toCharArray())
            if (word != '0') {
                num1 = num1 * 10 + word - '0';
                num2 += word - '0';
            }
        return num1 * num2;
    }
}