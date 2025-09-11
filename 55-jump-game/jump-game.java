class Solution {
    public boolean canJump(int[] nums) {
        int power=0;
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(power>=i)
            {
                int newpower=nums[i]+i;
                power=Math.max(newpower,power);
            }
            else
            {
                return false;
            }

        }
        return true;
        
    }
}