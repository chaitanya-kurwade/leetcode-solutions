class Solution {
    public int romanToInt(String s) {
        int result = 0;

        if (s.contains("IV")) {
            result += 4;
            s = s.replaceFirst("IV", "");
        }
        if (s.contains("IX")) {
            result += 9;
            s = s.replaceFirst("IX", "");
        }
        if (s.contains("XL")) {
            result += 40;
            s = s.replaceFirst("XL", "");
        }
        if (s.contains("XC")) {
            result += 90;
            s = s.replaceFirst("XC", "");
        }
        if (s.contains("CD")) {
            result += 400;
            s = s.replaceFirst("CD", "");
        }
        if (s.contains("CM")) {
            result += 900;
            s = s.replaceFirst("CM", "");
        }

        for (char c : s.toCharArray()) {
            if (c == 'I') result += 1;
            else if (c == 'V') result += 5;
            else if (c == 'X') result += 10;
            else if (c == 'L') result += 50;
            else if (c == 'C') result += 100;
            else if (c == 'D') result += 500;
            else if (c == 'M') result += 1000;
        }

        return result;
    }
}
