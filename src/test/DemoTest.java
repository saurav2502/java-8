package test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class DemoTest {
    public static void main(String[] args) throws IOException {
        //intermediateMethods();
        //flatmapCall();
        //flatmapCallToInt();
        //listToMap();
        //find the first even number greater than 3 from a list and return result = number * 2
        //getNumbers();
        //return a map<String, integer> of given list of people which will have name as key and count as value
        //createMap();
        //use of collectors maxBy, minBy, sumBy
        //collectorsOperation();
        //flatMapping
        flatMappingMethod();


    }

    private static void flatMappingMethod() {
        List<Person> persons = create();
        System.out.println(
                persons.stream()
                .collect(groupingBy(Person::getAge,
                        flatMapping(person -> Stream.of(person.getName().split("")), toList())))
        );
    }

    private static void collectorsOperation() {
        List<Person> persons = create();
        String result = persons.stream().collect(
                collectingAndThen(maxBy(comparing(Person::getAge)),
                        person -> person.map(Person::getName).orElse("")
                )
        );
        System.out.println(result);
        result = persons.stream().collect(
                collectingAndThen(minBy(comparing(Person::getAge)),
                        person -> person.map(Person::getName).orElse("")
                )
        );
        System.out.println(result);
    }

    private static void createMap() {
        List<Person> personList = create();
        Map<String, Integer> countByName = personList.stream()
                .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
        System.out.println(countByName);
        Map<String, Long> countByNamelong = personList.stream()
                .collect(groupingBy(Person::getName, counting()));
        System.out.println(countByNamelong);
    }

    private static void getNumbers() {
        List<Integer> items = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
        int result = 0;
        long startTime = System.currentTimeMillis();
        long endTime;
        for (Integer item : items) {
            if (item > 3 && item % 2 == 0) {
                result = item * 2;
                break;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("total time for loop : " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        System.out.println("first even num greater than 3: " +
                items.stream()
                        .filter(DemoTest::isGT3)
                        .filter(DemoTest::isEven)
                        .map(DemoTest::doubleIt)
                        .findFirst()
                        .orElse(0)
        );
        endTime = System.currentTimeMillis();
        System.out.println("total time for loop : " + (endTime - startTime));
    }

    private static Integer doubleIt(Integer integer) {
        System.out.println("double value " + integer);
        return integer * 2;
    }

    private static boolean isEven(Integer integer) {
        System.out.println("isEven value " + integer);
        return integer % 2 == 0;
    }

    private static boolean isGT3(Integer integer) {
        System.out.println("isGT3 value " + integer);
        return integer > 3;
    }

    private static void listToMap() {
        List<Person> persons = create();
        System.out.println("List to map: " +
                persons.stream()
                        .collect(toMap(person -> person.getName() + "_" + person.getAge(), person -> person)));

        //given a list people, create a map where key is name and value is all people with that name
        System.out.println("map: " +
                persons.stream()
                        .collect(groupingBy(Person::getName, mapping(Person::getAge, toList()))));
    }

    private static List<Person> create() {
        return Arrays.asList(
                new Person("saurav", 28),
                new Person("monu", 32),
                new Person("saurav", 32),
                new Person("monu", 33),
                new Person("suraj", 30),
                new Person("amit", 25),
                new Person("akash", 25),
                new Person("deepak", 31)
        );
    }

    private static void flatmapCallToInt() {
        int[] array = {1, 2, 3, 4, 5, 6};
        List<String> items = Arrays.asList("1", "2", "3", "4", "5", "6");
        IntStream intStream = Stream.of(array)
                .flatMapToInt(Arrays::stream);
        List<Integer> integerList = intStream.boxed()
                .collect(Collectors.toList());
        System.out.println(integerList);
        items.stream()
                .map(Integer::parseInt)
                .forEach(System.out::println);
        System.out.println("total sums are: " +
                items.stream()
                        .map(Integer::parseInt)
                        .reduce(0, Integer::sum));

        // checking multiplication of even no.
        System.out.println("even sums are: " +
                items.stream()
                        .map(Integer::parseInt)
                        .filter(num -> num % 2 == 0)
                        .mapToDouble(e -> e * 2)
                        .sum()
        );
    }

    private static void flatmapCall() {
        List<List<Integer>> lists = List.of(List.of(1, 2, 3, 4, 5));
        System.out.println(lists);
        List<Integer> integerList = lists.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(integerList);
        String[] a = {"A", "B"};
        String[] b = {"C", "D"};
        String[] strings = Stream.of(a, b)
                .flatMap(Arrays::stream)
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strings));
    }

    private static void intermediateMethods() {
        List<String> samples = List.of("1", "2", "3", "4", "5");
        Predicate<Integer> p1 = (data) -> data % 2 == 0;
        List<Integer> sampleList = samples.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        sampleList.stream()
                .filter(p1)
                .forEach(r -> System.out.println(r.intValue()));
        System.out.println(samples);
        System.out.println(sampleList);
    }
}
