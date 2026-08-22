class Solution {
    public boolean checkDivisibility(int n) {
        int p=1;
        int s=0;
        int r=n;
        while(n>0)

        {
            int d=n%10;
            p=p*d;
            s=s+d;
            n=n/10;
        }
        int add=s+p;
        if(r%add==0)
        {
            return true;
        }
        return false;
    }
}