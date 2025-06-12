class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k%=len;
        rotateArr(nums,0,len-1);
        rotateArr(nums,0,k-1);
        rotateArr(nums,k,len-1);
    }
    private void rotateArr(int []nums,int left,int right){
        while(left<right){
            int temp = nums[left];
            nums[left ] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}