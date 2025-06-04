class Solution {
    public String answerString(String word, int n) {
        if (n == 1) return word;

        String ans = "";
        int m = word.length();
        int mx_part_len = m - n + 1;

        for (int i = 0; i < m; i++) {
            StringBuilder tmp = new StringBuilder();

            for (int j = i; j < Math.min(i + mx_part_len, m); j++) {
                tmp.append(word.charAt(j));
            }

            if (tmp.toString().compareTo(ans) > 0) {
                ans = tmp.toString();
            }
        }

        return ans;
    }
}