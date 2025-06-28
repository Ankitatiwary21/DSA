class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        if (k == nums.length)
            return nums;

        // Copy nums to a temp array to find k largest elements
        int[] temp = Arrays.copyOf(nums, nums.length);

        // Use a partial sort to place the k largest elements in the first k slots (unordered)
        Arrays.sort(temp); // Java doesn't have nth_element, so sort entire array (O(n log n) worst-case)
        int threshold = temp[temp.length - k]; // k-th largest

        // Count how many times threshold appears in the top-k largest
        int countThreshold = 0;
        for (int i = temp.length - k; i < temp.length; i++) {
            if (temp[i] == threshold)
                countThreshold++;
        }

        int[] result = new int[k];
        int index = 0;

        for (int num : nums) {
            if (num > threshold) {
                result[index++] = num;
            } else if (num == threshold && countThreshold > 0) {
                result[index++] = num;
                countThreshold--;
            }
            if (index == k)
                break;
        }

        return result; 
    }
}