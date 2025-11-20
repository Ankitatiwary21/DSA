class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int ans = 0;
        int p1 = -1, p2 = -1; // last two chosen numbers
        
        for (int[] in : intervals) {
            boolean c1 = p1 >= in[0];
            boolean c2 = p2 >= in[0];
            if (c1 && c2) continue;
            else if (c1 || c2) {
                ans++;
                p1 = p2;
                p2 = in[1];
            } else {
                ans += 2;
                p1 = in[1] - 1;
                p2 = in[1];
            }
        }
        return ans;
    }
}