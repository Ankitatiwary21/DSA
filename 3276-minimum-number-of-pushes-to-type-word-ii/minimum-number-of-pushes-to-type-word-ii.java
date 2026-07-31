class Solution {
    public int minimumPushes(String word) {
        
        Map<Character, Integer> count = new HashMap<>();
        for (char c : word.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
       
        List<Integer> freq = new ArrayList<>(count.values());
        
       
        Collections.sort(freq, Collections.reverseOrder());
        
        int res = 0;
        for (int i = 0; i < freq.size(); i++) {
            res += ((i / 8) + 1) * freq.get(i);
        }
        
        return res;
    }
}