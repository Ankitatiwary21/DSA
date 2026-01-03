class Solution {
    public int numOfWays(int n) {
        long mod = 1000000007;
        long typeA = 6; // 3! = 6 ways for all-different
        long typeB = 6; // 3*2 = 6 ways for two-same pattern
        
        for (int i = 2; i <= n; i++) {
            long newA = (typeA * 2 + typeB * 2) % mod;
            long newB = (typeA * 2 + typeB * 3) % mod;
            typeA = newA;
            typeB = newB;
        }
        
        return (int)((typeA + typeB) % mod);
    }
}