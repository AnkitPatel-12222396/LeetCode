class Solution {

    public int merge(int [] a,int low,int mid,int high){
        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) a[i] > 2L * (long) a[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }

        // Merge the two sorted halves
        ArrayList<Integer> list = new ArrayList<>();
        int left = low, right = mid + 1;
        while (left <= mid && right <= high) {
            if (a[left] <= a[right]) {
                list.add(a[left++]);
            } else {
                list.add(a[right++]);
            }
        }
        while (left <= mid) list.add(a[left++]);
        while (right <= high) list.add(a[right++]);

        for (int i = low; i <= high; i++) {
            a[i] = list.get(i - low);
        }
        return cnt;
        }
        
    

    public int mergeSort(int[]arr,int low,int high){        
        int count = 0;
        if (low>=high) return count;
        int mid = (low+high)/2;

        count+=mergeSort(arr,low,mid);
        count+=mergeSort(arr,mid+1,high);
        count+=merge(arr,low,mid,high);
        return count;
    }

    public int reversePairs(int[] nums) {
        int n= nums.length;
        return mergeSort(nums,0,n-1);
    }
}