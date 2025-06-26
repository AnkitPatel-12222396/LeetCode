class Solution {
    public int longestSubsequence(String s, int k) {
        int res = 0;
        int cost = 1;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0' || cost <= k) {
                k -= cost * (s.charAt(i) - '0');
                ++res;
            }
            if (cost <= k) {
                cost *= 2;
            }
        }
        return res;
    }
}
