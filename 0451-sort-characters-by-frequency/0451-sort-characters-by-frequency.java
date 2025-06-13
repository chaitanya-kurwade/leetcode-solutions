class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        StringBuilder result = new StringBuilder();
        boolean[] used = new boolean[128];
        for (int count = 0; count < s.length();) {
            int maxFreq = 0;
            char maxChar = 0;
            for (int i = 0; i < 128; i++) {
                if (!used[i] && freq[i] > maxFreq) {
                    maxFreq = freq[i];
                    maxChar = (char) i;
                }
            }
            for (int i = 0; i < maxFreq; i++) {
                result.append(maxChar);
                count++;
            }
            used[maxChar] = true;
        }
        return result.toString();
    }
}
