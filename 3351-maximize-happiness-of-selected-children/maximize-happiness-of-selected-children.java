class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length;
        long sum = 0;
        int decrease = 0;
        
        for (int i = n - 1; i >= 0 && k > 0; i--) {
            int val = Math.max(happiness[i] - decrease, 0);
            sum += val;
            decrease++;
            k--;
        }
        return sum;
    }
}