class Solution {
    public int lengthOfLongestSubstring(String s) {
         int i = 0, j = 0, maxLength = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (j < s.length()) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(i, hashMap.get(s.charAt(j)) + 1);
            }
            hashMap.put(s.charAt(j), j);
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}