class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int [][]dp = new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i] = matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int minValue = dp[i+1][j];
                if(j>0){
                    minValue = Math.min(minValue,dp[i+1][j-1]);
                }
                if(j<n-1){
                    minValue = Math.min(minValue,dp[i+1][j+1]);
                }
                dp[i][j] = matrix[i][j]+minValue;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            min = Math.min(min,dp[0][i]);
        }
        return min;
    }
}