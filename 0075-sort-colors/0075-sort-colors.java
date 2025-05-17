class Solution {
    public void sortColors(int[] nums) {
        Map<Integer,Integer>map = new HashMap<>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int count  = 0;
        int start = 0;
        for(int i=0;i<3;i++){
            if(map.containsKey(i)){
                count += map.get(i);
            }
            for(int j=start;j<count;j++){
                nums[j] = i;
            }
            start=count;
        }
    }
}