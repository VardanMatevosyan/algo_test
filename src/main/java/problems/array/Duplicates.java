package problems.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        throw new RuntimeException();
    }


}
