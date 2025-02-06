class Solution {
    public int coinChange(int[] coins, int amount) {
        int m = coins.length;
        int n = amount;
        int [][] dp = new int [m+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(j>=coins[i-1]){
                    dp[i][j]  =Math.min(1+dp[i][j-coins[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n]==Integer.MAX_VALUE-1?-1:dp[m][n];
    }
}