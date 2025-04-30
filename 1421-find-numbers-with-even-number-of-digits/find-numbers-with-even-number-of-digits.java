class Solution {
    public int findNumbers(int[] nums) {
         int result = 0;

        for (int num : nums) {
            int digitCount = (int)(Math.log10(num)) + 1;
            
            if (digitCount % 2 == 0) {
                result++;
            }
        }

        return result;
    }
}