class Solution {
    public int maxTwoEvents(int[][] events) {
                Arrays.sort(events, Comparator.comparingInt(a -> a[1]));
        int n = events.length;

        
        int[] maxValue = new int[n];
        maxValue[0] = events[0][2];

    
        for (int i = 1; i < n; i++) {
            maxValue[i] = Math.max(maxValue[i - 1], events[i][2]);
        }

        int maxSum = 0;

        
        for (int i = 0; i < n; i++) {
            
            int currValue = events[i][2];

            
            int low = 0, high = i - 1, idx = -1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (events[mid][1] < events[i][0]) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            
            if (idx != -1) {
                maxSum = Math.max(maxSum, currValue + maxValue[idx]);
            } else {
                maxSum = Math.max(maxSum, currValue);
            }
        }

        return maxSum;
    }
}