class Solution {
    public int[] leftRightDifference(int[] nums) {
        int answer[]=new int[nums.length];
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }

        int curr=0;
        for(int i=0;i<nums.length;i++)
        {
        int leftsum=curr;
        curr+=nums[i];
        int rightsum=sum-curr;

        
            answer[i]=Math.abs(rightsum-leftsum);
        }
        return answer;
        
    }
}