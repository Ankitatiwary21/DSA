class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxE = Arrays.stream(nums).max().getAsInt();

        int n = nums.length;

        long result = 0;

        List<Integer> maxIndices = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == maxE) {
                maxIndices.add(i);
            }

            int size = maxIndices.size();
            if (size >= k) {
                int last_i = maxIndices.get(size - k);
                result += last_i + 1;
            }
        }

        return result; 
    }
}