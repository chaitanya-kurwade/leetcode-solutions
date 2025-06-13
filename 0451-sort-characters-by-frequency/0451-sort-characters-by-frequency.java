class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char ch = maxHeap.poll();
            int freq = freqMap.get(ch);
            for (int i = 0; i < freq; i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}