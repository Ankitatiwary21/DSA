class Solution {
    String s[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String>res=new ArrayList<>();
        if(digits.length()==0)
        return res;
        backtrack(digits,res,"",0);
        return res;
    }
    public void backtrack(String digits,List<String>res,String curr,int ind)
    {
        if(ind==digits.length())
        {
            res.add(curr);
            return;
        }
        String key=s[digits.charAt(ind)-'0'];
        for(int i=0;i<key.length();i++)
        {
            backtrack(digits,res,curr+key.charAt(i),ind+1);
        }
    }
}