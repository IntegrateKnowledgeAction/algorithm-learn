import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MinWindow {


    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }

                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }


    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        HashSet<Character> window = new HashSet<>();
        int res = 0;
        int len = s.length();
        while (right < len) {
            while (right < len && !window.contains(s.charAt(right))) {
                window.add(s.charAt(right));
                right++;
            }
            res = Math.max(res, right - left);
            window.remove(s.charAt(left));
            left++;
        }
        return res;
    }


}


