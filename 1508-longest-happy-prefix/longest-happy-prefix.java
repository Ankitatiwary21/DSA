class Solution {
    public String longestPrefix(String s) {
     char c[]=s.toCharArray();//level
     int n=c.length;///5
     int max=0,i=1;
     int a[]=new int[n];//to store longest happy prefix length at every possible index
     while(i<n)
     {
        //1<5
        if(c[max]==c[i])
        {
            max++;
        a[i]=max;
        i++;
        }
        else
        {
            if(max>0)
            {
                max=a[max-1];
            }
            else
            {
                a[i]=0;
                i++;
            }
        }
     } 
     return s.substring(0,a[n-1]);
    }
}