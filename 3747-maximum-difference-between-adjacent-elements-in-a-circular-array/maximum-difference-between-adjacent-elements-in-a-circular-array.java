class Solution {
    public int maxAdjacentDistance(int[] nums) {
          int n = nums.length;
        int maxDiff = Math.abs(nums[0] - nums[n - 1]);

        for (int i = 0; i < n - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i + 1]));
        }

        return maxDiff;
    }
}