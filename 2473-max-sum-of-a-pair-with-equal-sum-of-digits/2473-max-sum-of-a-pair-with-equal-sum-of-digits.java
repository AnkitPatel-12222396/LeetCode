class Solution {
    public int maximumSum(int[] nums) {
        int max = -1;
        Map<Integer,Integer>map = new HashMap<>();
        
        for(int num:nums){
            int temp = num;
            int sum =0;
            while(temp>0){
                int rem = temp%10;
                temp/=10;
                sum+=rem;
            }
            if (map.containsKey(sum)){
                max = Math.max(max,num+map.get(sum));
                if(map.get(sum)>num) continue;
                else map.put(sum,num);

            }else{
                map.put(sum,num);
            }
        }
        return max;
    }
}