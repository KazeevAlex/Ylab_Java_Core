package homework_2.task1_person_groupingBy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/*
        Task1
            Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени.

            Что должно получиться:
                Key:Amelia
                Value:4
                Key: Emily
                Value:1
                Key: Harry
                Value:3
                Key: Jack
                Value:1
*/
public class Main {
    public static void main(String[] args) {
        Map<String, Long> result = Arrays.stream(RAW_DATA)
                .filter(Objects::nonNull)
                .distinct()
                .sorted(Comparator.comparing(Person::getId))
                .collect(Collectors.groupingBy(Person::getName, Collectors.counting()));

        for (Map.Entry<String, Long> e : result.entrySet()) {
            System.out.println("Key: " + e.getKey() + System.lineSeparator() + "Value: " + e.getValue());
        }
    }

    private static final Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    static class Person {
        final int id;
        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }
}
