class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n*(n+1)/2;
        int digitsum = 0;
        for(int i=0;i<nums.length;i++){
            digitsum = digitsum+nums[i];
        }
        return sum-digitsum;
    }
}