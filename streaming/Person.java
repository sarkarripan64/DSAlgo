package streaming;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;

/**
 * Created by sarkarri on 11/21/16.
 */
public class Person {
    private String name;
    private int age;
    Gender gender;

    public Person(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public static void main(String[] args) {
        List<Person> people = createPeople();
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.stream().forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                
            }
        });

//        System.out.println(people.stream()
//                .filter(person -> person.getAge() > 25)
//                .filter(Person::is4LetterName));
//        //.findFirst());
//        //System.out.println(names);
//        Stream.iterate(1, e -> e + 1)
//                .filter(e -> e % 2 == 0)
//                .limit(10)
//                .forEach(System.out::println);

        System.out.println(people.stream().collect(groupingBy(Person::getName, mapping(Person::getAge, toList()))));
    }

    static boolean is4LetterName(Person person) {
        System.out.println("called");
        return person.getName().length() == 4;
    }


    private static List<Person> createPeople() {
        return Arrays.asList(
                new Person("Sara", 20, Gender.FEMALE),
                new Person("Sara", 22, Gender.FEMALE),
                new Person("Bob", 20, Gender.MALE),
                new Person("Paula", 32, Gender.FEMALE),
                new Person("Paul", 32, Gender.MALE),
                new Person("Jack", 2, Gender.MALE),
                new Person("Jack", 72, Gender.MALE),
                new Person("Jill", 12, Gender.MALE)
        );
    }

    @Override
    public String toString() {
        return this.getName() + ":" + this.getAge() + ":" + this.getGender();
    }
}
