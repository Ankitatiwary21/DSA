class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length();
        boolean[] sorted = new boolean[n - 1];
        int deletions = 0;
        
        for (int c = 0; c < m; c++) {
            boolean bad = false;
            for (int r = 0; r < n - 1; r++) {
                if (!sorted[r] && strs[r].charAt(c) > strs[r + 1].charAt(c)) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                deletions++;
            } else {
                for (int r = 0; r < n - 1; r++) {
                    if (!sorted[r] && strs[r].charAt(c) < strs[r + 1].charAt(c)) {
                        sorted[r] = true;
                    }
                }
            }
        }
        return deletions;
    }
}