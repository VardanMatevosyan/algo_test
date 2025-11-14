package problems.array;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AnagramTest {
    private static final Anagram anagram = new Anagram();

    @ParameterizedTest(name = "return true if anagram is valid, else false")
    @CsvSource({
            "anagram, nagaram, true",
            "rat, car, false",
            "listen, silent, true",
            "hello, world, false"
    })
    public void when_SecondStringIsAnagramOfTheFirstString_returnTrueElseFalse(String s, String t, boolean expected) {
        boolean isValid = anagram.isAnagram(s, t);
        Assertions.assertEquals(expected, isValid);
    }

}