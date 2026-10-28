import java.util.BitSet;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        BitSet[][] dp = new BitSet[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new BitSet(1024);
            }
        }

        dp[0][0].set(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }

                BitSet combined = new BitSet(1024);

                if (i > 0) {
                    combined.or(dp[i - 1][j]);
                }

                if (j > 0) {
                    combined.or(dp[i][j - 1]);
                }

                for (int xorVal = combined.nextSetBit(0);
                     xorVal >= 0;
                     xorVal = combined.nextSetBit(xorVal + 1)) {

                    dp[i][j].set(xorVal ^ grid[i][j]);
                }
            }
        }

        return dp[m - 1][n - 1].nextSetBit(0);
    }
}