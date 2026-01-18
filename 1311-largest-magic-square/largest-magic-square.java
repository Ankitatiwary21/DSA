class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] rowSum = new int[m + 1][n + 1];
        int[][] colSum = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rowSum[i + 1][j + 1] = rowSum[i + 1][j] + grid[i][j];
                colSum[i + 1][j + 1] = colSum[i][j + 1] + grid[i][j];
            }
        }
        
        int maxK = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 2; i + k <= m && j + k <= n; k++) {
                    if (isMagic(grid, rowSum, colSum, i, j, k)) {
                        maxK = Math.max(maxK, k);
                    }
                }
            }
        }
        return maxK;
    }
    
    private boolean isMagic(int[][] grid, int[][] rowSum, int[][] colSum, int r, int c, int k) {
        int target = rowSum[r + 1][c + k] - rowSum[r + 1][c];
        for (int i = 0; i < k; i++) {
            if (rowSum[r + i + 1][c + k] - rowSum[r + i + 1][c] != target) return false;
            if (colSum[r + k][c + i + 1] - colSum[r][c + i + 1] != target) return false;
        }
        int d1 = 0, d2 = 0;
        for (int i = 0; i < k; i++) {
            d1 += grid[r + i][c + i];
            d2 += grid[r + i][c + k - 1 - i];
        }
        return d1 == target && d2 == target;
    }
}