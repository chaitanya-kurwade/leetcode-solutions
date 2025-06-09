class Solution {
    public int maxDepth(String s) {
        int maxDepth = 0;
        int currentDepth = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            }
            if (c == ')') {
                currentDepth--;
            }
        }
        return maxDepth;
    }
}