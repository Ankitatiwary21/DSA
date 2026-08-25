class Solution {
    public int missingMultiple(int[] nums, int k) {

        int multiple = k;

        while (true) {

            boolean found = false;

            // Check whether this multiple exists in nums
            for (int num : nums) {
                if (num == multiple) {
                    found = true;
                    break;
                }
            }

            // If it does not exist, this is our answer
            if (!found) {
                return multiple;
            }

            // Try the next multiple of k
            multiple += k;
        }
    }
}