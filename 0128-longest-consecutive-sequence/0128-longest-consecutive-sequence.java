class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int  max = 1;
        int count =1;
        if(nums.length==0)return 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]) continue;
            if(nums[i] == nums[i-1]+1) count+=1;
            else{
                max = Math.max(max,count);
                count =1;
            }
        }
        return Math.max(max,count);
    }
}