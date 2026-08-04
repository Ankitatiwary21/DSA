class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>ans=new ArrayList<>();
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
            }
            if(nums[i]<min)
            {
                min=nums[i];
            }
        }
        
        for(int j=min;j<max;j++)
        {
            boolean found = false;

    for(int i = 0; i < n; i++)
    {
        if(nums[i] == j)
        {
            found = true;
            break;
        }
    }

    if(!found)
    {
        ans.add(j);

    }
        }
        return ans;
    }
}