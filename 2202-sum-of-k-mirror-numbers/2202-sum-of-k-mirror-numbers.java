class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int length = 1;

        while (count < n) {
            // Generate base-10 palindromes of current length
            for (long p : generatePalindromes(length)) {
                if (isKPalindrome(p, k)) {
                    sum += p;
                    count++;
                    if (count == n)
                        break;
                }
            }
            length++;
        }
        return sum;
    }

    private static List<Long> generatePalindromes(int length) {
        List<Long> result = new ArrayList<>();
        int half = (length + 1) / 2;
        long start = (long) Math.pow(10, half - 1);
        long end = (long) Math.pow(10, half);

        for (long i = start; i < end; i++) {
            String firstHalf = Long.toString(i);
            StringBuilder sb = new StringBuilder(firstHalf);
            if (length % 2 == 1)
                sb.deleteCharAt(sb.length() - 1);
            String palindrome = firstHalf + sb.reverse().toString();
            result.add(Long.parseLong(palindrome));
        }
        return result;
    }

    private static boolean isKPalindrome(long num, int k) {
        String baseK = convertToBaseK(num, k);
        return isPalindrome(baseK);
    }

    private static String convertToBaseK(long num, int k) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append(num % k);
            num /= k;
        }
        return sb.reverse().toString();
    }

    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }
}
