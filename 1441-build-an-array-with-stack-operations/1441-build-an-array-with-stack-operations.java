class Solution {
    public List<String> buildArray(int[] target, int n) {
        ArrayList<String> list = new ArrayList<>();
        int len = target.length;
        int el =1;
        for(int i=0;i<target[len-1];i++){
            if(i>=len)break;
            list.add("Push");
            while(target[i]!=el){
                list.add("Pop");
                el++;
                list.add("Push");
            }
            el++;
        }
        return list;
    }
}