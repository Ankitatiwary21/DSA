class Solution {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length, n = mat[0].length;
        int[][] prefix = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = mat[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
        
        int low = 0, high = Math.min(m, n), ans = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canFind(mid, threshold, prefix)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
    
    private boolean canFind(int size, int threshold, int[][] prefix) {
        int m = prefix.length - 1, n = prefix[0].length - 1;
        for (int i = size; i <= m; i++) {
            for (int j = size; j <= n; j++) {
                int sum = prefix[i][j] - prefix[i - size][j] - prefix[i][j - size] + prefix[i - size][j - size];
                if (sum <= threshold) return true;
            }
        }
        return false;
    }
}