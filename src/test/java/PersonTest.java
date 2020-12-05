import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonTest {
    private List<Person> people;
    private Person person1;
    private Person person2;
    private Person person3;
    private Person person4;

    @Before
    public void setUp() {
        person1 = new Person("Peter", LocalDate.of(1993, 6, 9),
                Person.Sex.MALE, "peter@gmail.com");
        person2 = new Person("Andrew", LocalDate.of(1993, 6, 9),
                Person.Sex.MALE, "andrew@gmail.com");
        person3 = new Person("Adam", LocalDate.of(1992, 1, 29),
                Person.Sex.MALE, "adam@gmail.com");
        person4 = new Person("Jun", LocalDate.of(1991, 10, 18),
                Person.Sex.MALE, "jun@gmail.com");
        people = new ArrayList<>(Arrays.asList(person1, person2, person3, person4));
    }

    @Test
    public void testConstructor() {
        Assert.assertNotNull(people.get(0));
    }

    @Test
    public void testNullaryConstructor() {
        Person person = new Person();
        Assert.assertNotNull(person);
    }

    @Test
    public void testGetName() {
        String expected = "Peter";
        String actual = people.get(0).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSetName() {
        String expected = "Todd";
        people.get(0).setName(expected);
        String actual = people.get(0).getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgePerson1() {
        int expected = 27;
        int actual = person1.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgePerson2() {
        int expected = 27;
        int actual = person2.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgePerson3() {
        int expected = 28;
        int actual = person3.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testAgePerson4() {
        int expected = 29;
        int actual = person4.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        String expected = "Person{" +
                "name='" + people.get(0).getName() + '\'' +
                ", birthday=" + people.get(0).getBirthday() +
                ", gender=" + people.get(0).getGender() +
                ", emailAddress='" + people.get(0).getEmailAddress() + '\'' +
                '}';
        String actual = people.get(0).toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPrintPerson() {
        person1.printPerson();
    }

    @Test
    public void testPrintPersonOlderThan() {
        Person.printPersonsOlderThan(people, 25);

    }

    @Test
    public void testPrintPersonsWithinAgeRange() {
        Person.printPersonsWithinAgeRange(people, 24, 28);
    }

    @Test
    public void printPersonTestForLambdaClass() {
        Person.printPersons(people,
                (Person p) -> p.getGender() == Person.Sex.MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25
        );

    }
}
