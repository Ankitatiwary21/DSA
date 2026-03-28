class Solution {
    public double findMaxAverage(int[] nums, int k) {
       int n=nums.length;
       int windowsum=0;
       double average=0.0;
       for(int i=0;i<k;i++)
       {
           windowsum+=nums[i];
           average=(double)windowsum/k;
       }
       double maxsum=average;
       for(int j=k;j<n;j++)
       {
           windowsum+=nums[j];
           windowsum-=nums[j-k];
           average=(double)windowsum/k;
           maxsum=Math.max(maxsum,average);
       }
       return maxsum;
    }
}