class Solution {
        public int maximumLength(int[] nums, int k) {
    int[][] dp = new int[k][k];
    int maxLen = 0;

    for (int num : nums) {
        int currMod = num % k;
        for (int prevMod = 0; prevMod < k; prevMod++) {
            dp[prevMod][currMod] = dp[currMod][prevMod] + 1;
            maxLen = Math.max(maxLen, dp[prevMod][currMod]);
        }
    }

    return maxLen;
    }
}