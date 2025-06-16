class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = nums1.length;
        for(int i=m-1;i>=0;i--){
            nums1[len-m+i] = nums1[i];
        }
        int i=n;
        int j=0;
        int index = 0;
        while(i<m+n &&j<n){
            if(nums1[i]<=nums2[j]) nums1[index++] = nums1[i++];
            else nums1[index++] = nums2[j++];
        }
        while(i<m+n) nums1[index++] = nums1[i++];
        while(j<n) nums1[index++] = nums2[j++];
    }
}