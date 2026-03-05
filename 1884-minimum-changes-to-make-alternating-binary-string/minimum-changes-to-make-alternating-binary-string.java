class Solution {
    public int minOperations(String s) {
        int mismatch1 = 0, mismatch2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';
            if (s.charAt(i) != expected1) mismatch1++;
            if (s.charAt(i) != expected2) mismatch2++;
        }
        return Math.min(mismatch1, mismatch2);
    }
}