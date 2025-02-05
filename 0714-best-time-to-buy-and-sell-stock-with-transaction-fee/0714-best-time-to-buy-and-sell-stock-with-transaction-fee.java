class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash = 0, hold = -prices[0]; // cash: profit when not holding, hold: profit when holding stock
        
        for (int i = 1; i < n; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);  // sell the stock
            hold = Math.max(hold, cash - prices[i]);  // buy the stock
        }
        
        return cash;  
    }
}
