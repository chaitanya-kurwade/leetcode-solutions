class Solution {
    public boolean checkRecord(String s) {
        return isEligible(s, 0, 0, 0);
    }

    private static boolean isEligible(String s, int index, int absentCount, int lateCount) {
        if (index == s.length()) {
            return true;
        }
        char ch = s.charAt(index);
        if (ch == 'A') {
            absentCount++;
            lateCount = 0;
        } else if (ch == 'L') {
            lateCount++;
        } else { // ch == 'P'
            lateCount = 0;
        }
        if (absentCount >= 2 || lateCount >= 3) {
            return false;
        }
        return isEligible(s, index + 1, absentCount, lateCount);
    }
}
