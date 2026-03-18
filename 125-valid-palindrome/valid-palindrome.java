class Solution {
    private boolean isAlphaNumeric(char c)
    {
        if(c>='a' && c<='z')
        return true;
        if(c>='A'&& c<='Z')
        return true;
        if(c>='0'&&c<='9')
        return true;
        return false;
    }
    private char tolower(char c)
    {
        if(c>='A'&&c<='Z')
        {
            return (char)(c+32);
        }
        return c;
    }
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right)
        {
            while(left<right && !isAlphaNumeric(s.charAt(left)))
            {
                left++;
            }
            while(left<right && !isAlphaNumeric(s.charAt(right)))
            {
                right--;
            }
            if(tolower(s.charAt(left))!=tolower(s.charAt(right)))
            {
                return false;
            }
            left++;
            right--;
        }
        return true;
        
    }
}