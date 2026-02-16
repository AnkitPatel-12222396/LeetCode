public class Solution {
    public int reverseBits(int n) {
        int result =0;
        for(int i=0;i<32;i++){
            int lsb=0;
            if(((n>>i)&1)==1){
                lsb=1<<31-i;
            
            result = result|lsb;
            }
            
        }
        return result;
    }
}