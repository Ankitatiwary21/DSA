class Solution {
    public double soupServings(int n) {
        if (n >= 5000) return 1.0;
        Map<String, Double> memo = new HashMap<>();
        return backtrack(n, n, memo);
    }

    private double backtrack(int a, int b, Map<String, Double> memo) {
        if (a <= 0 && b <= 0) return 0.5;
        if (a <= 0) return 1.0;
        if (b <= 0) return 0.0;

        String key = a + "," + b;
        if (memo.containsKey(key)) return memo.get(key);

        double res = 0.25 * backtrack(a - 100, b, memo)
                   + 0.25 * backtrack(a - 75, b - 25, memo)
                   + 0.25 * backtrack(a - 50, b - 50, memo)
                   + 0.25 * backtrack(a - 25, b - 75, memo);

        memo.put(key, res);
        return res;
    }
}