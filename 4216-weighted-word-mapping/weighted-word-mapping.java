class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
         StringBuilder result = new StringBuilder(words.length);

        for (String word : words) {
            int temp = 0;
            for (int i = 0; i < word.length(); i++) {
                temp += weights[word.charAt(i) - 'a'];
            }

            result.append((char) ('z' - (temp % 26)));
        }

        return result.toString();
    }
}