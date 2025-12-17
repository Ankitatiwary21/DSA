class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        long[][][] dp = new long[k+1][n][3];
        
        for (int t = 1; t <= k; t++) {
            dp[t][0][1] = -prices[0]; // normal buy
            dp[t][0][2] = prices[0];  // short sell
            for (int i = 1; i < n; i++) {
                dp[t][i][0] = Math.max(dp[t][i-1][0],
                                       Math.max(dp[t][i-1][1] + prices[i], dp[t][i-1][2] - prices[i]));
                dp[t][i][1] = Math.max(dp[t][i-1][1], dp[t-1][i-1][0] - prices[i]);
                dp[t][i][2] = Math.max(dp[t][i-1][2], dp[t-1][i-1][0] + prices[i]);
            }
        }
        return dp[k][n-1][0];
    }
}