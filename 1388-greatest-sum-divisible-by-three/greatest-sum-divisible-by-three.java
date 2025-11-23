class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = {0, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : nums) {
            int[] temp = dp.clone();
            for (int r = 0; r < 3; r++) {
                temp[(r + num) % 3] = Math.max(temp[(r + num) % 3], dp[r] + num);
            }
            dp = temp;
        }
        return dp[0];
    }
}