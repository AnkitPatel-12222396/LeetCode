class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n = spells.length;
        int m = potions.length;
        int [] res = new int [n];       
        for(int i=0;i<n;i++){
            int l=0;
            int r = m-1;
            int minIndex = m;
            while(l<=r){
            int mid = l + (r-l)/2;
            if((long) spells[i] * potions[mid] >= success){
                minIndex = mid;
                r=mid-1;
            }else{
                l = mid+1;
            }

            }
            res[i] = m-minIndex;
        }
        return res;
    }
}