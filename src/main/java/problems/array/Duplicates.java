package problems.array;

import java.util.*;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Find duplicates in an array or collection.
 * Replace the exception with a solution and run test class to view the result.
 */
public class Duplicates {

    public boolean hasDuplicate(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        return IntStream.of(numbers).anyMatch(n -> !set.add(n));
    }

    public <T> boolean hasDuplicate(List<T> array) {
        Set<T> set = new HashSet<>();
        return array.stream().anyMatch(n -> !set.add(n));
    }

    public <T, K> boolean hasDuplicate(List<T> array, Function<T, K> keyExtractor) {
        Set<K> set = new HashSet<>();
        return array.stream().anyMatch(n -> !set.add(keyExtractor.apply(n)));
    }

    /**
     * Google's problem on the interview.
     * Given a string s, remove duplicate letters so that every letter appears once and only once.
     * You must make sure your result is the smallest in lexicographical order among all possible results.
     * ------------------------------------
     * Example 1:
     * Input: s = "bcabc"
     * Output: "abc"
     * ------------------------------------
     * Example 2:
     * Input: s = "cbacdcbc"
     * Output: "acdb"
     *
     * @param s string of literals
     * @return string without duplicate and with the smallest in lexicographical order among all possible results
     */
    public String removeDuplicateLetters(String s) {
//       To solve the problem the stack + frequency + lookup technique used
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Boolean> visited = new HashMap<>();
        char[] chars = s.toCharArray();
        Map<Character, Integer> freq = getFrequencyArray(chars);

        for (char c : chars) {
            decreaseCharFrequency(c, freq);
            if (isIncluded(c, visited)) continue;

            while (!stack.isEmpty()) {
                Character top = stack.peek();
                if (c < top && canBeLater(freq, top)) {
                    stack.pop();
                    visited.remove(top);
                } else break;
            }

            stack.push(c);
            visited.put(c, true);
        }

        return getResult(stack);
    }

    private static void decreaseCharFrequency(char c, Map<Character, Integer> freq) {
        freq.computeIfPresent(c, (k, v) -> v - 1);
    }

    private static boolean canBeLater(Map<Character, Integer> frequencies, Character top) {
        return frequencies.get(top) > 0;
    }

    private String getResult(Deque<Character> stack) {
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pollLast());
        }
        return builder.toString();
    }

    private boolean isIncluded(char c, Map<Character, Boolean> visited) {
        return visited.containsKey(c);
    }

    private Map<Character, Integer> getFrequencyArray(char[] chars) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : chars) {
            frequencies.merge(c, 1, Integer::sum);
        }
        return frequencies;
    }


}
