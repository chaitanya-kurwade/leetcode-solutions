class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                int bitCount = Integer.bitCount(hour) + Integer.bitCount(minute);
                if (bitCount == turnedOn) {
                    result.add(hour + ":" + String.format("%02d", minute));
                }
            }
        }
        return result;
    }
}