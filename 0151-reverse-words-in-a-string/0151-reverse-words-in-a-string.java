class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        List<String> list = new ArrayList<String>();
        for (int i = words.length - 1; i >= 0; i--) {
            list.add(words[i]);
        }
        return String.join(" ", list);
    }
}