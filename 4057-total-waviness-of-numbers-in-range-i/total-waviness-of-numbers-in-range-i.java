class Solution {
    public int find(int num)
    {
        String s=Integer.toString(num);
        int l=s.length();
        if(l<3)
        return 0;
        int score=0;
        for(int i=1;i<=l-2;i++){
            if(s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1))
            score++;
            if(s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1))
            score++;
        }
        return score;
    }
    public int totalWaviness(int num1, int num2) {
        int score=0;
        for(int num=num1;num<=num2;num++)
        {
            score+=find(num);
        }
        return score;

        
    }
}