package problems.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

/**
 * Find duplicates in an array or collection.
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


}
