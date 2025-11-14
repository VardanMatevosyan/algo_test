package problems.array;


import java.util.Arrays;

import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * ------------------------------------
 * What is anagram?
 * An anagram is a word or phrase formed
 * by rearranging the letters of another word or phrase,
 * using all the original letters exactly once.
 * ------------------------------------
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 * ------------------------------------
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 */
public class Anagram {


    /**
     * Is anagram valid?
     * Replace exception with the solution and run related test.
     * @param s first string
     * @param t second string
     * @return true if t is anagram of s, else false
     */
    public boolean isAnagram(String s, String t) {
        if (isBlank(s) || isBlank(t) || s.length() != t.length()) {
            return false;
        }
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

}
