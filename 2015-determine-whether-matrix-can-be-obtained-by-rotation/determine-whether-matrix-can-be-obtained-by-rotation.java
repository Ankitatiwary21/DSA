class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for (int r = 0; r < 4; r++) {
            if (isEqual(mat, target)) return true;
            mat = rotate90(mat);
        }
        return false;
    }
    
    private boolean isEqual(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }
    
    private int[][] rotate90(int[][] mat) {
        int n = mat.length;
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                res[j][n - 1 - i] = mat[i][j];
        return res;
    }
}