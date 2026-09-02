
class Solution {
    public boolean uniformArray(int[] nums1) {

        int odd = 0;
        int even = 0;

        for (int num : nums1) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        // All elements already have the same parity
        if (odd == 0 || even == 0) {
            return true;
        }

        // There is at least one odd and one even.
        // We can make every element have the same parity
        // using nums1[i] - nums1[j].
        return true;
    }
}

