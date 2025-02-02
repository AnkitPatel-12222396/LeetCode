class Solution {
    public boolean check(int[] nums) {
        int count = 0;
        int len = nums.length;
        for(int i=0;i<len;i++){
            int prev =  (i-1+len)%len;
            int next = (i+1)%len; 
            if(nums[i]>=nums[prev] && nums[i]<=nums[next]) continue;
            else count++;
            if (count>2) return false;
        }
        return true;
    }
}