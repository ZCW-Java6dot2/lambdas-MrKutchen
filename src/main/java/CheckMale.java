public class CheckMale implements CheckPerson {
    @Override
    public boolean test(Person p) {
        return p.getGender().equals(Person.Sex.MALE);
    }
}
