class Solution {
    static final int MOD = 1_000_000_007;
    public long distributeCandies(int n, int limit) {
        long total = nC2(n + 2);

        // Subtract ways where at least one variable > limit
        for (int i = 1; i <= 3; i++) {
            total -= countExceed(n, limit, i);
        }

        return total;
    }

    // Total combinations (n + 2 choose 2)
    static long nC2(long n) {
        return n * (n - 1) / 2;
    }

    static long countExceed(int n, int limit, int varsExceeding) {
        long res = 0;

        for (int mask = 1; mask < (1 << 3); mask++) {
            int bits = Integer.bitCount(mask);
            if (bits != varsExceeding) continue;

            int sub = bits * (limit + 1);
            int remaining = n - sub;
            if (remaining < 0) continue;

            // number of solutions to x + y + z = remaining
            res += nC2(remaining + 2);
        }

        return res * (varsExceeding % 2 == 1 ? 1 : -1);
    }
}