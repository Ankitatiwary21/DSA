class Solution {
    public int minimumOperations(int[] nums) {
        int ops = 0;
        for (int num : nums) {
            int rem = num % 3;
            if (rem != 0) ops++;
        }
        return ops;
    }
}