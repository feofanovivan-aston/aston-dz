import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Тестирование MyHashSet");
        MyHashSet<String> mySet = new MyHashSet<>();
        mySet.insert("Hello");
        mySet.insert("World");
        mySet.insert("Hello");
        System.out.println("Set: " + mySet);
        mySet.remove("World");
        System.out.println("После удаления: " + mySet);

        System.out.println("\n Тестирование MyArrayList");
        MyArrayList<Integer> myList = new MyArrayList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        System.out.println("List: " + myList);
        System.out.println("Get(1): " + myList.get(1));
        myList.remove(1);
        System.out.println("После удаления индекса 1: " + myList);

        List<Student> students = Arrays.asList(
            new Student("Иван", Arrays.asList(
                new Book("Java Basics", "Author1", 1999, 200),
                new Book("Advanced Java", "Author2", 2005, 350),
                new Book("Design Patterns", "Author3", 2010, 150),
                new Book("Clean Code", "Author4", 2003, 400),
                new Book("Algorithms", "Author5", 1998, 300)
            )),
            new Student("Мария", Arrays.asList(
                new Book("Data Structures", "Author6", 2001, 250),
                new Book("Spring Framework", "Author7", 2007, 500),
                new Book("Hibernate", "Author8", 2015, 180),
                new Book("Microservices", "Author9", 2003, 320),
                new Book("Docker", "Author10", 2018, 280)
            )),
            new Student("Петр", Arrays.asList(
                new Book("Kubernetes", "Author11", 2019, 450),
                new Book("AWS", "Author12", 2020, 380),
                new Book("React", "Author13", 2017, 220),
                new Book("Vue.js", "Author14", 2016, 190),
                new Book("Angular", "Author15", 2015, 410)
            ))
        );

        System.out.println("\n Результат стрима");
        students.stream()
            .peek(System.out::println)
            .flatMap(student -> student.getBooks().stream())
            .sorted()
            .distinct()
            .filter(book -> book.getYear() > 2000)
            .limit(3)
            .map(Book::getYear)
            .findFirst()
            .ifPresentOrElse(
                year -> System.out.println("Год выпуска найденной книги: " + year),
                () -> System.out.println("Книга не найдена")
            );
    }
}