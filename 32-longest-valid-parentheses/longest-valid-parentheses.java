class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0)
        return 0;
       Stack<Integer> stack=new Stack<>();
       stack.push(-1);//to handle base condition like starting is directly closing bracket
       int max=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')
            {
                stack.push(i);
            }
            else
            {
                stack.pop();
            }
            if(stack.isEmpty())
            {
                stack.push(i);
            }
            else
            {
              max=Math.max(max,i-stack.peek());
            }
        }
        return max;
    }
}