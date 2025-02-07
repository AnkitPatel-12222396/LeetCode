class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int l=1;
        int r = piles[piles.length-1];
        int res = piles[piles.length-1];
        while(l<=r){
            int mid = l+(r-l)/2;
            long sum =0;
            for(int i=0;i<piles.length;i++){
                sum+=((piles[i]+mid-1)/mid);
            }
            if(sum<=h){
                res = Math.min(res,mid);
                r= mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}