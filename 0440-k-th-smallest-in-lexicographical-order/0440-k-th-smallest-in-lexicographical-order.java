class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k--; // since we start from 1

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // move to next prefix
                current++;
                k -= steps;
            } else {
                // go deeper in prefix tree
                current *= 10;
                k--;
            }
        }

        return current;
    }

    private long countSteps(int n, long n1, long n2) {
        long steps = 0;
        while (n1 <= n) {
            steps += Math.min(n + 1, n2) - n1;
            n1 *= 10;
            n2 *= 10;
        }
        return steps;
    }
}
