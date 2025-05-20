class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
         int n = nums.length;
        long[] maxDecrements = new long[n + 1];

        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            maxDecrements[left]++;
            maxDecrements[right + 1]--;
        }

        for (int i = 1; i < n; i++) {
            maxDecrements[i] += maxDecrements[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > maxDecrements[i]) {
                return false;
            }
        }

        return true;
    }
}