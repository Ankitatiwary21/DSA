class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long[] minPref = new long[k];
        Arrays.fill(minPref, Long.MAX_VALUE);
        
        long sum = 0, ans = Long.MIN_VALUE;
        minPref[0] = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = (i + 1) % k;
            if (minPref[mod] != Long.MAX_VALUE) {
                ans = Math.max(ans, sum - minPref[mod]);
            }
            minPref[mod] = Math.min(minPref[mod], sum);
        }
        
        return ans;
    }
}