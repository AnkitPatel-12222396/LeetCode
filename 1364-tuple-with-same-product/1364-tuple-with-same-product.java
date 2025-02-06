class Solution {
    public int nc2(int n){
        return (n*(n-1))/2;
    }
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        final int[] res = {0};
        Map <Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<n-1;i++){
            for(int j =i+1;j<n;j++){
                int mul = nums[i]*nums[j];
                map.put(mul,map.getOrDefault(mul,0)+1);
            }
        }
        map.forEach((key, value) -> {
    if (value >= 2) {
        res[0] += 8*nc2(value);
    }
});
        return res[0];
    }
}