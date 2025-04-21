class Solution {
    public int numberOfSubstrings(String s) {
    int seen[]={-1,-1,-1};
    int c=0;
    for(int i=0;i<s.length();i++)
    {
        seen[s.charAt(i)-'a']=i;
        if(seen[0]!=-1 || seen[1]!=-1 ||seen[2]!=-1)
        {
            c=c+Math.min(seen[0],Math.min(seen[1],seen[2]))+1;
        }
    }
    return c;
    }
}