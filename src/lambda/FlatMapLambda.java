package lambda;

import data.Bike;
import data.Student;
import data.StudentDatabase;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Saurav Kumar
 * @project java-8
 * @since 7/12/2020
 */

public class FlatMapLambda {
    public static Predicate<Student> studentPredicate = (student) -> student.getGradeLevel() ==2;
    public static void main(String[] args) {
        OptionalFlatMap();
    }

    private static void OptionalFlatMap() {
        Optional<Student> studentOptional = Optional.ofNullable(StudentDatabase.studentSupplier.get());
        Optional<String> bikeName = studentOptional
                                                .filter(studentPredicate)
                                                .flatMap(Student::getBike)
                                                .map(Bike::getName);
        bikeName.ifPresent(s-> System.out.println("Bike name : "+s));
    }
}
