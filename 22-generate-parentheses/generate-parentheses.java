class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(n, res, "", 0, 0);
        return res;
    }

    void backtrack(int n, List<String> res, String curr, int open, int close) {
        if (open == close && open == n) {
            res.add(curr);
            return;
        }

        if (open < n) {
            backtrack(n, res, curr + '(', open + 1, close);
        }

        if (close < open) {
            backtrack(n, res, curr + ')', open, close + 1);
        }
    }
}
