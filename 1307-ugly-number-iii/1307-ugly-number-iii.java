class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long low = 1, high = 2_000_000_000;
        long ab = lcm(a, b);
        long bc = lcm(b, c);
        long ac = lcm(a, c);
        long abc = lcm(a, bc);

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / a + mid / b + mid / c
                       - mid / ab - mid / bc - mid / ac
                       + mid / abc;

            if (count < n) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return (int) low;
    }

    private static long gcd(long x, long y) {
        return y == 0 ? x : gcd(y, x % y);
    }

    private static long lcm(long x, long y) {
        return x / gcd(x, y) * y;
    }
}
