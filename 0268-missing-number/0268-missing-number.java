class Solution {
    public int missingNumber(int[] nums) {
        int len  = nums.length;
        int ans = 0;
        for(int i=1;i<=len;i++){
            ans^=i;
        }
        for(int i=0;i<len;i++){
            ans^=nums[i];
        }
        return ans;
    }
}