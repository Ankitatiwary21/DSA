class Solution {
    public int numSub(String s) {
        long res = 0, count = 0;
        long mod = 1_000_000_007;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                count++;
                res += count;
            } else {
                count = 0;
            }
        }
        return (int)(res % mod);
    }
}