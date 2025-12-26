class Solution {
    public int bestClosingTime(String customers) {
        int penalty = 0;
        for (char c : customers.toCharArray()) 
            if (c == 'Y') penalty++;
        
        int minPenalty = penalty, hour = 0;
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') penalty--;
            else penalty++;
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                hour = i + 1;
            }
        }
        return hour;
    }
}