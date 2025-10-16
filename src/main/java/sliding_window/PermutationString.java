package sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

/**
 * PermutationString class.
 * Check if s2 contains a permutation of s1.
 * For example, s1 = "ab", s2 = "eidbaooo" -> true.
 * s1 = "ab", s2 = "eidboaoo" -> false.
 * -----------------------------------------------------------------------------------------
 * Technique:
 * Sliding window algorithm approach was implemented.
 * Time complexity O(n).
 * Space complexity O(1) because the HashMap will contain at most 26 characters
 * but specifically for this example of values.
 * -----------------------------------------------------------------------------------------
 * Note: comparing  Integers using == works only for less than 128 values.
 * Values between -128 and 127 are cached internally by the JVM.
 * So == works for these small values because they point to the same object in the Heap.
 * -----------------------------------------------------------------------------------------
 * Advice: Use .equals() for comparing Integer values.
 */
class PermutationString {

    private static final BiFunction<Character, Integer, Integer> DECREMENT_OR_REMOVE = (k, v) -> v > 1 ? v - 1 : null;

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        Map<Character, Integer> charCountMap = new HashMap<>();
        Map<Character, Integer> windowCharCountMap = new HashMap<>();
        int windowSize = s1.length();

        populateCharCountMap(s1, charCountMap);
        populateWindowCharCountMap(s2, windowSize, windowCharCountMap);

        if (charCountMap.equals(windowCharCountMap)) {
            return true;
        }

        for (int i = windowSize; i < s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - windowSize);

            increaseCharCount(windowCharCountMap, newChar);
            decrementCharCountOrRemove(windowCharCountMap, oldChar);

            if (charCountMap.equals(windowCharCountMap)) {
                return true;
            }
        }
        return false;
    }

    private void populateWindowCharCountMap(String s2, int windowSize, Map<Character, Integer> windowCharCountMap) {
        for (int i = 0; i < windowSize; i++) {
            increaseCharCount(windowCharCountMap, s2.charAt(i));
        }
    }

    private void populateCharCountMap(String s1, Map<Character, Integer> charCountMap) {
        for (char c : s1.toCharArray()) {
            increaseCharCount(charCountMap, c);
        }
    }

    private void decrementCharCountOrRemove(Map<Character, Integer> windowCharCountMap, char oldChar) {
        windowCharCountMap.computeIfPresent(oldChar, DECREMENT_OR_REMOVE);
    }

    private void increaseCharCount(Map<Character, Integer> charCountMap, char newChar) {
        charCountMap.merge(newChar, 1, Integer::sum);
    }

}

