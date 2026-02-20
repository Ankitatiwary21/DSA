import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> parts = new ArrayList<>();
        int count = 0, start = 0;
        
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                // Recursively process the middle part
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                parts.add("1" + inner + "0");
                start = i + 1;
            }
        }
        
        // Sort in reverse to get lexicographically largest
        Collections.sort(parts, Collections.reverseOrder());
        return String.join("", parts);
    }
}