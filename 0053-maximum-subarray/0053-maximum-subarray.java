class Solution {
    public int maxSubArray(int[] nums) {
        int res = Integer.MIN_VALUE;
        // int sum =0;
        int currSum =0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            currSum+=nums[i];
            res = Math.max(res,currSum);
            currSum = Math.max(currSum,nums[i]);
            if(currSum<0) currSum= 0;
        }
        return res;
    }
}