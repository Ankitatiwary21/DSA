class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxc=0;
        int current=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==1)
            {
                current++;
            }
            else{
                maxc=Math.max(maxc,current);
                current=0;
            }
        }
        return Math.max(maxc,current);
    }
}