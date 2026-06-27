class Solution {
    public int splitArray(int[] nums, int k) {
        int start=0;
        int end=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>start){
                start=nums[i];
            }
            end=end+nums[i];
        }
        int ans=end;

        while(end>=start){
            int mid = start+(end-start)/2;
            int currentSum=0;
            int count=1;
            boolean possible=true;
            for(int i=0;i<nums.length;i++){
                if(currentSum+nums[i]>mid){
                    currentSum=nums[i];
                    count++;
                    if(count>k){
                        possible=false;
                        break;
                    }
                }else{
                    currentSum=currentSum+nums[i];
                }
            }

            if(possible){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
}