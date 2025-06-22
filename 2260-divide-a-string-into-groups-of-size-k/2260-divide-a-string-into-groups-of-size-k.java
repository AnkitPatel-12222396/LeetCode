class Solution {
    public String[] divideString(String s, int k, char fill) {
        int len = s.length();
        int rem = len%k;
        StringBuilder sb = new StringBuilder(s);

        if(rem!=0){for(int i=0;i<(k-rem);i++){
            sb.append(fill);
        }}
        System.out.println(s);
        String[] ans = new String[sb.length()/k];
        int index = 0;
        for(int i=0;i<sb.length();i+=k){
             ans[index++] = sb.substring(i,i+k);
        }
        return ans;
    }
}