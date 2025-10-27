class Solution {
    public int numberOfBeams(String[] bank) {
        int prev = 0, beams = 0;
        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }
            if (count > 0) {
                beams += prev * count;
                prev = count;
            }
        }
        return beams;
    }
}