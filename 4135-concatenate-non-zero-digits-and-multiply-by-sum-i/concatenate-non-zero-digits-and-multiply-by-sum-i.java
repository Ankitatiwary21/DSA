class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        long sum = 0;
        long pow10 = 1;

        while (n > 0) {
            int digit = n % 10;

            sum += digit;

            if (digit > 0) {
                x += digit * pow10;
                pow10 *= 10;
            }

            n /= 10;
        }

        return x * sum;
    }
}