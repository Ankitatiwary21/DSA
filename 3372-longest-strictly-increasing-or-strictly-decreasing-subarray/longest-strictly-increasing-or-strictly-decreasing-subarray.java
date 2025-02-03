class Solution {
    public int longestMonotonicSubarray(int[] nums) {
      int n=nums.length;
      int result=1;
      int inc=1;
      int dec=1;
      for(int i=1;i<n;i++)
      {
        if(nums[i]>nums[i-1])
        {
            inc++;
            dec=1;
            result=Math.max(result,inc);
        }
         else if(nums[i]<nums[i-1])
        {
            dec++;
            inc=1;
            result=Math.max(result,dec);
        }
        else
        {
            inc=1;
            dec=1;
        }
      }
      return result;
    }
}