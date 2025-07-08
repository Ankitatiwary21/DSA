class Solution {
       private int[][] memo;
    private int[][] events;
    private int[] starts;   // start times for binary search
    private int n;

    public int maxValue(int[][] events, int k) {
        // sort by start day (tie‑break by end day)
        Arrays.sort(events, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        this.events = events;
        this.n = events.length;
        this.memo = new int[n][k + 1];

        for (int[] row : memo) Arrays.fill(row, -1);

        // cache of start times for binary search
        starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = events[i][0];

        return dfs(0, k);
    }

    private int dfs(int i, int k) {
        if (k == 0 || i == n) return 0;
        if (memo[i][k] != -1) return memo[i][k];

        int value = events[i][2];
        int end   = events[i][1];

        // next non‑overlapping event index via upper_bound (first start > end)
        int nextIdx = upperBound(starts, end);

        int take = value + dfs(nextIdx, k - 1); // attend current
        int skip = dfs(i + 1, k);               // skip current

        return memo[i][k] = Math.max(take, skip);
    }

    // upperBound: first index whose value > target
    private int upperBound(int[] arr, int target) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] <= target) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}