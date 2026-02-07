class Solution {
    public int minimumDeletions(String s) {
        int n = s.length();
        int[] A = new int[n];
        
        // Step 1: Calculate number of 'a's to the right of each index
        A[n - 1] = s.charAt(n - 1) == 'a' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            A[i] = A[i + 1] + (s.charAt(i) == 'a' ? 1 : 0);
        }

        // Step 2: Calculate minimum deletions
        int result = Integer.MAX_VALUE;
        int bCount = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'b') {
                result = Math.min(result, bCount + A[i]);
                bCount++;
            }
        }

        // Check if the result was updated or not
        result = Math.min(result, bCount);

        return result;
    }
}