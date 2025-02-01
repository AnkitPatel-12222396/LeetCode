class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==0 || nums.length==1) return true;
        if(nums.length==2){
            return (nums[0]+nums[1])%2!=0;
        }
        for(int i=1;i<nums.length-1;i++){
            if((nums[i]+nums[i-1])%2!=0 && (nums[i]+nums[i+1])%2!=0) continue;
            else return false;

        }
        return true;

    }
}