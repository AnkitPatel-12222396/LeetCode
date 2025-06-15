class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int index=Integer.MIN_VALUE;
        boolean swapped = false;
        for(int i=len-2;i>=0;i--){
            if(nums[i]<nums[i+1]) {
                index = i;
                break;}
        }
        if(index==Integer.MIN_VALUE) reverse(nums,0,len-1);
        else{
            for(int i=len-1;i>index;i--){
            if(nums[i]>nums[index] ) {
                swap(nums,i,index);
                break;
                }
                
            }
            reverse(nums,index+1,len-1);
        }
    }
    public void reverse(int[]nums,int first,int last){
        while(first<last){
            int temp = nums[first];
            nums[first ] = nums[last];
            nums[last] = temp;
            first++;
            last--;
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}