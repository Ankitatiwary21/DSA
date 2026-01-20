class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            ans[i] = -1; // default
            for (int x = 0; x < num; x++) {
                if ((x | (x + 1)) == num) {
                    ans[i] = x;
                    break;
                }
            }
        }
        return ans;
    }
}