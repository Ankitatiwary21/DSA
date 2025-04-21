class Solution {
    public int minOperations(int[] nums, int[] numsDivide) {
        int x=0;
        for(int i:numsDivide)
        {
            x=gcd(x,i);
        }
        int y=Integer.MAX_VALUE;
        for(int i:nums)
        {
            if(x%i==0)
            y=Math.min(y,i);
        }
        if(y==Integer.MAX_VALUE)
        return -1;
        int c=0;
        for(int i:nums)
        {
            if(i<y)
            c++;
        }
        return c;
    }
    public int gcd(int a,int b)
    {
        return b==0?a:gcd(b,a%b);
    }
}