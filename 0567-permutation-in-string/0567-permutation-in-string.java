class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        // Initialize frequency for s1 and the first window in s2
        for (int i = 0; i < len1; i++) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        // Check for matching window
        if (matches(s1Count, s2Count)) return true;

        // Slide window across s2
        for (int i = len1; i < len2; i++) {
            s2Count[s2.charAt(i) - 'a']++;                     // add new char
            s2Count[s2.charAt(i - len1) - 'a']--;              // remove old char
            if (matches(s1Count, s2Count)) return true;        // compare counts
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
