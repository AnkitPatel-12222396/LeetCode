class Solution {
    public String makeFancyString(String s) {
        if(s.length()<3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for(int i=1;i<s.length()-1;i++){
            if(s.charAt(i)==(s.charAt(i-1) ) && s.charAt(i)==(s.charAt(i+1))){
                continue;
            }
            sb.append(s.charAt(i));
        }
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}