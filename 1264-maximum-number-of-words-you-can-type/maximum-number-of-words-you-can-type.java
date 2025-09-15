class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
         boolean[] broken = new boolean[26];
        for (char ch : brokenLetters.toCharArray()) {
            broken[ch - 'a'] = true;
        }

        int result = 0;
        boolean foundBroken = false;

        // Step 2: Iterate through text character by character
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (ch == ' ') { // End of a word
                if (!foundBroken) {
                    result++;
                }
                foundBroken = false; // reset for next word
            } else if (broken[ch - 'a']) {
                foundBroken = true; // found a broken letter in this word
            }
        }

        // Step 3: Check last word (no space after last word)
        if (!foundBroken) {
            result++;
        }

        return result;
    }
}