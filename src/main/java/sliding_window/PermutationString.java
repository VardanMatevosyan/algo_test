package sliding_window;

import java.util.HashMap;
import java.util.Map;

// Note
// comparing  Integers using == works only for less than 128 values.
class PermutationString {

    public static void main(String[] args) {
        PermutationString ps = new PermutationString();
//        example 1
//        String s1 = "ab";
//        String s2 = "eidbao"; // true
//        String s2 = "eidboaoo"; // false

//      example 2
//        String s1 = "a";
//        String s2 = "ab"; // true

//      example 3
//        String s1 = "adc";
//        String s2 = "dcda"; // true//

//        example 4
//        String s1 = "abcdxabcde";
//        String s2 = "abcdeabcdx"; // true

//        example 5
        String s1 = "hello";
        String s2 = "ooolleoooleh"; // false

        boolean result = ps.checkInclusion(s1, s2);
        System.out.println("Result for " + s1 + " in " + s2 + " is " + result);
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        // Create frequency maps for s1 and the initial window of s2
        Map<Character, Integer> s1_map = new HashMap<>();
        Map<Character, Integer> s2_map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            s1_map.put(c, s1_map.getOrDefault(c, 0) + 1);
        }

        int windowSize = s1.length();

        // Initialize the first window in s2
        for (int i = 0; i < windowSize; i++) {
            s2_map.put(s2.charAt(i), s2_map.getOrDefault(s2.charAt(i), 0) + 1);
        }

        // Compare the initial window
        if (s1_map.equals(s2_map)) {
            return true;
        }

        // Sliding window: move the window across s2
        for (int i = windowSize; i < s2.length(); i++) {
            char newChar = s2.charAt(i);  // new character entering the window
            char oldChar = s2.charAt(i - windowSize);  // old character leaving the window

            // Add the new character to the window
            s2_map.put(newChar, s2_map.getOrDefault(newChar, 0) + 1);

            // Remove the old character from the window
            if (s2_map.get(oldChar) == 1) {
                s2_map.remove(oldChar);  // remove completely if the count goes to 0
            } else {
                s2_map.put(oldChar, s2_map.get(oldChar) - 1);
            }

            // Check if the current window matches the frequency map of s1
            if (s1_map.equals(s2_map)) {
                return true;
            }
        }

        return false;
    }

}

