class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k)
        return false;
        if(s.length()==k)
        return true;
        int count[]=new int[26];
        for(int i=0;i<s.length();i++)
        {
            count[s.charAt(i)-'a']++;
        }
        int c=0;
        for(int i=0;i<26;i++)
        {
            if(count[i]%2!=0)
            c++;
        }
        return (c<=k);
    }
}