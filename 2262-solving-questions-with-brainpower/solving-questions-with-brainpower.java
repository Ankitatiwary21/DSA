class Solution {
    public long mostPoints(int[][] questions) {
         int n = questions.length;
        
        if (n == 1) 
            return questions[0][0];

        long[] dp = new long[n + 1]; // Equivalent to t[200001] in C++, but we only need size (n + 1)
        
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int skip = questions[i][1];

           
            long take = points + ((i + skip + 1 < n) ? dp[i + skip + 1] : 0);
            
            // If we skip this question, we take the best result from dp[i+1]
            long skipQuestion = dp[i + 1];

            // Store the maximum of both choices
            dp[i] = Math.max(take, skipQuestion);
        }

        return dp[0];
    }
}