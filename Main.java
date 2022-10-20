package lesson9;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Course course1 = new CourseImpl("Java");
        Course course2 = new CourseImpl("JavaScript");
        Course course3 = new CourseImpl("Python");
        Course course4 = new CourseImpl("C++");
        Course course5 = new CourseImpl("C#");
        Course course6 = new CourseImpl("Ruby");
        Course course7 = new CourseImpl("PHP");
        Course course8 = new CourseImpl("Kotlin");
        Course course9 = new CourseImpl("Curry");
        Course course10 = new CourseImpl("Swift");

        List<Student> students = Arrays.asList(
                new StudentImpl("Ivanova", Arrays.asList(course1, course3, course8)),
                new StudentImpl("Petrov", Arrays.asList(course7)),
                new StudentImpl("Smirnova", Arrays.asList(course1, course2)),
                new StudentImpl("Sviridov", Arrays.asList(course1, course3, course5)),
                new StudentImpl("Volkov", null),
                new StudentImpl("Levkin", Arrays.asList(course8, course10)),
                new StudentImpl("Popova", Arrays.asList(course5, course7)),
                new StudentImpl("Semenov", Arrays.asList(course6)),
                new StudentImpl("Abramov", Arrays.asList(course2, course7, course8)),
                new StudentImpl("Dolgina", null)

        );

        System.out.println(getUniqueCourses(students));
        System.out.println(getCuriousStudent(students));
        System.out.println(getStudentsByCourses(students, course5));
    }

    public static List<Course> getUniqueCourses(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .map(Student::getAllCourses)
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<Student> getCuriousStudent(List<Student> students) {
        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .sorted((o1, o2) -> {
                    List<Course> c1 = o1.getAllCourses();
                    List<Course> c2 = o2.getAllCourses();
                    return Integer.compare(
                            c2 == null ? 0 : c2.size(),
                            c1 == null ? 0 : c1.size()
                    );
                })
                .limit(3)
                .collect(Collectors.toList());
    }

    public static List<Student> getStudentsByCourses(List<Student> students, Course course) {
        if (course == null) {
            return new ArrayList<>();
        }

        students = students == null ? new ArrayList<>() : students;

        return students.stream()
                .filter(Objects::nonNull)
                .filter(student -> {
                    List<Course> courses = student.getAllCourses();
                    courses = courses == null ? Collections.emptyList() : courses;
                    return courses.contains(course);
                })
                .collect(Collectors.toList());
    }
}
