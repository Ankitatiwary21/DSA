class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[] last = new int[m];
        java.util.Arrays.fill(last, -1);

        int j = m - 1;

        for (int i = n - 1; i >= 0; --i) {
            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }
        }

        java.util.ArrayList<Integer> ans = new java.util.ArrayList<>();

        int skip = 0;
        j = 0;

        for (int i = 0; i < n; i++) {
            if (j == m) {
                break;
            }

            if (word1.charAt(i) == word2.charAt(j) ||
                (skip == 0 && (j == m - 1 || i < last[j + 1]))) {

                if (word1.charAt(i) != word2.charAt(j)) {
                    skip = 1;
                }

                ans.add(i);
                j++;
            }
        }

        if (j != m) {
            return new int[0];
        }

        int[] result = new int[ans.size()];

        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}