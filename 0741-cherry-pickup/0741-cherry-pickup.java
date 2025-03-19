class Solution {
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        
        for (int[][] layer : dp)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        
        dp[0][0][0] = grid[0][0];
        
        for (int t = 1; t < 2 * n - 1; t++) {
            for (int x1 = Math.min(n - 1, t); x1 >= 0; x1--) {
                for (int x2 = Math.min(n - 1, t); x2 >= 0; x2--) {
                    int y1 = t - x1, y2 = t - x2;
                    if (y1 >= n || y2 >= n || grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        dp[x1][x2][t % n] = Integer.MIN_VALUE;
                        continue;
                    }
                    
                    int cherries = grid[x1][y1];
                    if (x1 != x2) cherries += grid[x2][y2];
                    
                    int best = Integer.MIN_VALUE;
                    if (x1 > 0) best = Math.max(best, dp[x1 - 1][x2][(t - 1) % n]);
                    if (x2 > 0) best = Math.max(best, dp[x1][x2 - 1][(t - 1) % n]);
                    if (x1 > 0 && x2 > 0) best = Math.max(best, dp[x1 - 1][x2 - 1][(t - 1) % n]);
                    if (y1 > 0 && y2 > 0) best = Math.max(best, dp[x1][x2][(t - 1) % n]);
                    
                    if (best != Integer.MIN_VALUE) 
                        dp[x1][x2][t % n] = best + cherries;
                    else 
                        dp[x1][x2][t % n] = Integer.MIN_VALUE;
                }
            }
        }
        
        return Math.max(0, dp[n - 1][n - 1][(2 * n - 2) % n]);
    }
}
