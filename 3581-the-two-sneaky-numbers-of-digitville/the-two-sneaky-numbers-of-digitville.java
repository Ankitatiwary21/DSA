class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2; 
        int[] freq = new int[n];
        for (int num : nums) {
            freq[num]++;
        }
        
        int[] result = new int[2];
        int index = 0;
         for (int i = 0; i < n; i++) {
            if (freq[i] == 2) {
                result[index++] = i;
                if (index == 2) break;  // We only need two numbers.
            }
        }
        
        return result;
    }
}