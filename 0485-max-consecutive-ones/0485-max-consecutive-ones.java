class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int j=-1;
        int max= 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                if(j!=-1){
                    max = Math.max(max,i-j);
                    j=i+1;
                }
            }
            else{
                if(j==-1) j=i;

            }
        }
        return (j==-1)?0:Math.max(max,nums.length-j);
    }
}