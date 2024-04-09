import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private int yearOfBirth;

    public Person(String id, String firstName, String lastName, String title, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.yearOfBirth = yearOfBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public int getAge() {
        return getAge(LocalDate.now().getYear());
    }

    public int getAge(int year) {
        return Period.between(LocalDate.of(yearOfBirth, 1, 1), LocalDate.of(year, 1, 1)).getYears();
    }

    public String toCSVDataRecord() {
        return id + "," + firstName + "," + lastName + "," + title + "," + yearOfBirth;
    }
}
