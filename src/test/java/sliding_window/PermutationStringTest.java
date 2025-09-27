package sliding_window;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class PermutationStringTest {

    private static final PermutationString permutationString = new PermutationString();

    @ParameterizedTest(name = "has permutation string")
    @MethodSource(value = "assertionSourcePermutationStringData")
    void hasPermutationString(String s1, String s2, boolean expected) {
        boolean result = permutationString.checkInclusion(s1, s2);
        Assertions.assertEquals(result, expected);
    }

    public static Stream<Arguments> assertionSourcePermutationStringData() {
        return Stream.of(
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("ab", "eidbao", true),
                Arguments.of("a", "ab", true),
                Arguments.of("adc", "dcda", true),
                Arguments.of("abcdxabcde", "abcdeabcdx", true),
                Arguments.of("hello", "ooolleooolehl", true)
        );
    }


}