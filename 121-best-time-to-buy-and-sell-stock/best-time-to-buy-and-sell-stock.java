class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] maxvalue=new int[n];
        maxvalue[n-1]=prices[n-1];
        for(int i=n-2;i>=0;i--)
        {
            maxvalue[i]=Math.max(maxvalue[i+1],prices[i]);

        }
        int ans=0;
        for(int i=0;i<prices.length;i++)
        {
            int curr=maxvalue[i]-prices[i];
            ans=Math.max(ans,curr);
        }
        return ans;
    }
}