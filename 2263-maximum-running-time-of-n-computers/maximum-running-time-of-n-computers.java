class Solution {
    public long maxRunTime(int n, int[] batteries) {
        Arrays.sort(batteries);
        long left = 1, right = 0;
        for (int b : batteries) right += b;
        
        while (left < right) {
            long mid = (left + right + 1) / 2;
            long total = 0;
            for (int b : batteries) total += Math.min(b, mid);
            if (total >= (long) n * mid) left = mid;
            else right = mid - 1;
        }
        return left;
    }
}