class Solution {
    public int countPartitions(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int x : nums) sum += x;

        // If total sum is even ➝ all partitions work (n-1)
        // If total sum is odd  ➝ no partitions work
        return (sum % 2 == 0) ? (n - 1) : 0;
    }
}