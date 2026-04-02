class Solution {
    public int maximumAmount(int[][] coins) {
  int m = coins.length;
        int n = coins[0].length;
        int[][][] dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        for (int k = 0; k <= 2; k++) {
            if (coins[0][0] < 0 && k > 0) {
                dp[0][0][k - 1] = 0;
            }
            dp[0][0][k] = Math.max(dp[0][0][k], coins[0][0]);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 2; k++) {
                    if (dp[i][j][k] == Integer.MIN_VALUE) continue;

                    if (j + 1 < n) {
                        int nextCoins = coins[i][j + 1];
                        dp[i][j + 1][k] = Math.max(dp[i][j + 1][k], dp[i][j][k] + nextCoins);
                        if (k > 0 && nextCoins < 0) {
                            dp[i][j + 1][k - 1] = Math.max(dp[i][j + 1][k - 1], dp[i][j][k]);
                        }
                    }

                    if (i + 1 < m) {
                        int nextCoins = coins[i + 1][j];
                        dp[i + 1][j][k] = Math.max(dp[i + 1][j][k], dp[i][j][k] + nextCoins);
                        if (k > 0 && nextCoins < 0) {
                            dp[i + 1][j][k - 1] = Math.max(dp[i + 1][j][k - 1], dp[i][j][k]);
                        }
                    }
                }
            }
        }

        int maxCoins = Integer.MIN_VALUE;
        for (int k = 0; k <= 2; k++) {
            maxCoins = Math.max(maxCoins, dp[m - 1][n - 1][k]);
        }
        return maxCoins;
    }
}