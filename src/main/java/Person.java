import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class Person {

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public Person(){
        this.name = "";
        this.birthday = LocalDate.now();
        this.gender = null;
        this.emailAddress = "";
    }

    public Person(String name, LocalDate birthday, Sex gender, String email){
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getAge() {
        LocalDate now = LocalDate.now();
        Period diff = Period.between(birthday, now);
        return diff.getYears();
    }

    public void printPerson() {
        String output = "Name: "+this.name+" Birthdate: "+this.birthday+" Gender: "+this.gender+" Email: "+emailAddress;
        System.out.println(output);
    }

    public static void printPersonsOlderThan(List<Person> people, int age) {
        for (Person p : people) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersonsWithinAgeRange(List<Person> people, int low, int high) {
        for (Person p : people) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(
            List<Person> people, CheckPerson tester) {
        for (Person p : people) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}