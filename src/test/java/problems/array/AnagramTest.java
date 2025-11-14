package problems.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class AnagramTest {
    private static final Anagram anagram = new Anagram();

    public static Stream<Arguments> anagramTestDataProvider() {
        return Stream.of(
                Arguments.of("anagram", "nagaram", true),
                Arguments.of("rat", "car", false),
                Arguments.of("listen", "silent", true),
                Arguments.of("hello", "world", false),
                Arguments.of("", "world", false),
                Arguments.of("hello", "", false),
                Arguments.of("", "", false),
                Arguments.of(null, "world", false),
                Arguments.of("world", null, false)
        );
    }


    @ParameterizedTest(name = "return true if anagram is valid, else false")
    @MethodSource(value = "anagramTestDataProvider")
    public void when_SecondStringIsAnagramOfTheFirstString_returnTrueElseFalse(String s, String t, boolean expected) {
        boolean isValid = anagram.isAnagram(s, t);
        Assertions.assertEquals(expected, isValid);
    }

}