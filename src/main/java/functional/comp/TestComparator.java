package functional.comp;

import asynchronous.Person;
import functional.Comparator;
import functional.Function;

public class TestComparator {
    public static void main(String[] args) {
        Person jos= new Person("Joseph",25);
        Person martin= new Person("Martin",25);
        Person lovely= new Person("Lovely",25);


        Function<Person,String> nameFunc = Person::getName;

        Comparator<Person> cmpPerson = Comparator.comparing(nameFunc);

        System.out.println(cmpPerson.compare(jos,martin));
        System.out.println(cmpPerson.compare(jos,lovely));
        System.out.println(cmpPerson.compare(lovely,martin));
    }


}
