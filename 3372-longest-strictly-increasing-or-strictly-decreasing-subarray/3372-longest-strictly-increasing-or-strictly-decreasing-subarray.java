class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int result = 1;
        int len = nums.length;
        int initial = 0;
        for(int i=1;i<len;i++){
            if(nums[i]>nums[i-1]){
                result = Math.max(result,i-initial+1);
            }
            else{
                initial = i;
            }
        }
        initial = 0;
        for(int i=1;i<len;i++){
            if(nums[i]<nums[i-1]){
                result = Math.max(result,i-initial+1);
            }
            else{
                initial = i;
            }
        }
        return result;
    }
}