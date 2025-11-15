package problems.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

class DuplicatesTest {

    private static final Duplicates duplicates = new Duplicates();

    public static Stream<Arguments> arraysData() {
        return Stream.of(
          Arguments.of(new int[]{1, 2, 3, 2, 5}, true),
          Arguments.of(new int[]{1, 2, 3, 4, 5}, false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "arraysData")
    public void when_AnArrayHasDuplicates_returnTrueElseFalse(int[] array, boolean expected) {
        boolean hasDuplicate = duplicates.hasDuplicate(array);
        Assertions.assertEquals(expected, hasDuplicate);
    }

    public static Stream<Arguments> collectionStringData() {
        return Stream.of(
                Arguments.of(List.of("Angelina", "Mariam", "Karina", "Angelina"), true),
                Arguments.of(List.of("Vano", "Mariam", "Karina", "Angelina"), false)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "collectionStringData")
    public void when_AnArrayHasDuplicates_returnTrueElseFalse(List<String> array, boolean expected) {
        boolean hasDuplicate = duplicates.hasDuplicate(array);
        Assertions.assertEquals(expected, hasDuplicate);
    }

    public static Stream<Arguments> collectionPersonData() {
        return Stream.of(
                Arguments.of(List.of(new Person(12, "Vano"), new Person(45, "Nino")), false),
                Arguments.of(List.of(new Person(6, "Angelina"), new Person(6, "Angelina")), true)
        );
    }

    @ParameterizedTest
    @MethodSource(value = "collectionPersonData")
    public void when_PersonArrayHasDuplicates_returnTrueElseFalse(List<Person> array, boolean expected) {
        boolean hasDuplicate = duplicates.hasDuplicate(array, p -> String.format("%s%d", p.getName(), p.getAge()));
        Assertions.assertEquals(expected, hasDuplicate);
    }


    private static class Person {
        private final int age;
        private final String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }

}