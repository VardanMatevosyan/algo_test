package binery_search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class BinarySearchIterativeTest {

    private static final BinarySearchIterative searcher = new BinarySearchIterative();

    @ParameterizedTest
    @MethodSource(value = "searcherTestDataProvider")
    void test_binary_search_find_expected_value(int[] numbs, int target, int expected) {
        int actual = searcher.search(numbs,  target);
        Assertions.assertEquals(expected,  actual);
    }

    public static Stream<Arguments> searcherTestDataProvider() {
        return Stream.of(
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12},  9,  4),
                Arguments.of(new int[]{-1, 0, 3, 5, 9, 12},  2,  -1),
                Arguments.of(new int[]{1},  1,  0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},  5,  4),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},  1,  0),
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9},  9,  8)
        );
    }


}