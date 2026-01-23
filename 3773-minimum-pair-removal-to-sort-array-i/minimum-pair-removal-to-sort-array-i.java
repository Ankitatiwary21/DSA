class Solution {
    public int minimumPairRemoval(int[] nums) {
        int ops = 0;
        while (!isSorted(nums)) {
            int idx = 0, minSum = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }
            nums = merge(nums, idx);
            ops++;
        }
        return ops;
    }
    private boolean isSorted(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            if (nums[i] < nums[i - 1]) return false;
        return true;
    }
    private int[] merge(int[] nums, int idx) {
        int[] res = new int[nums.length - 1];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (i == idx) {
                res[j++] = nums[i] + nums[i + 1];
                i++;
            } else {
                res[j++] = nums[i];
            }
        }
        return res;
    }
}