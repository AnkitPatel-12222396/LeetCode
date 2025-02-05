class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int count  = 0;
        int index = -1;
        if(s1.length()!=s2.length()) return false;
        for(int i = 0; i<s1.length(); i++){
            if (count == 1 && s1.charAt(i) != s2.charAt(i)){
                count++;
                if(s1.charAt(i) == s2.charAt(index)  && s1.charAt(index) == s2.charAt(i)) continue;
                else return false;
            }
            if(s1.charAt(i)!=s2.charAt(i)){
                count++;
                index = i;
            }
            
        }
        if (count==1 || count>2) return false;
        return true;
    }
}