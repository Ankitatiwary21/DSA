class Solution {
    public int trap(int[] h) {
        int n = h.length;
       int l=0,r=n-1;
       int lm=0,rm=0,w=0;
       while(l<r)
       {
        if(h[l]<h[r])
        {
            if(lm<=h[l])
            lm=h[l];
            else
            w=w+(lm-h[l]);//how much can we store in current posiiton
            l++;
        }
        else
        {
            if(rm<=h[r])
            rm=h[r];
            else
            w=w+(rm-h[r]);
            r--;
        }
       }
       return w;
    }
}