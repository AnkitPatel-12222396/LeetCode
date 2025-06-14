class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        // Try replacing each digit (0-9) with another digit (0-9)
        for (char from = '0'; from <= '9'; from++) {
            for (char to = '0'; to <= '9'; to++) {
                if (from == to) continue;

                StringBuilder sb = new StringBuilder();
                for (char c : s.toCharArray()) {
                    if (c == from) sb.append(to);
                    else sb.append(c);
                }

                int val = Integer.parseInt(sb.toString());
                max = Math.max(max, val);
                min = Math.min(min, val);
            }
        }
        
        return max - min;
    }
}