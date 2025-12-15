class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1, streak = 1;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) streak++;
            else streak = 1;
            total += streak;
        }
        return total;
    }
}