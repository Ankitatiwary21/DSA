

class Solution {

    // Compute LPS array for KMP
    void computeLPS(int[] pattern, int[] lps) {
        int len = 0;
        int i = 1;
        lps[0] = 0;

        while (i < pattern.length) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else if (len != 0) {
                len = lps[len - 1];
            } else {
                lps[i] = 0;
                i++;
            }
        }
    }

    // Check whether pattern occurs in text
    boolean search(int[] pat, int[] txt) {
        int n = txt.length;
        int m = pat.length;

        if (m == 0) return true;
        if (m > n) return false;

        int[] lps = new int[m];
        computeLPS(pat, lps);

        int i = 0, j = 0;

        while (i < n) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }

            if (j == m) {
                return true;
            } else if (i < n && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }

        return false;
    }

    // Check whether vec1 is a cyclic rotation of vec2
    boolean isRotation(int[] vec1, int[] vec2) {
        if (vec1.length != vec2.length) return false;
        if (vec1.length == 0) return true;

        int[] txt = new int[vec2.length * 2];

        System.arraycopy(vec2, 0, txt, 0, vec2.length);
        System.arraycopy(vec2, 0, txt, vec2.length, vec2.length);

        return search(vec1, txt);
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        if (n == 0) return 0;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int result = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {
                int[] vec1 = Arrays.copyOfRange(nums, start, start + k);
                int[] vec2 = Arrays.copyOfRange(sorted, start, start + k);

                if (!isRotation(vec1, vec2)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result += k;
            }
        }

        return result;
    }
}