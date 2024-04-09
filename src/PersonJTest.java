import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonJTest {
    private Person person;

    @BeforeEach
    public void setUp() {
        person = new Person("000001", "John", "Doe", "Mr.", 1980);
    }

    @Test
    public void testFullName() {
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        assertEquals("Mr. John Doe", person.formalName());
    }

    @Test
    public void testGetAge() {
        assertEquals(44, person.getAge());
    }

    @Test
    public void testGetAgeWithYear() {
        assertEquals(40, person.getAge(2020));
    }

    @Test
    public void testToCSVDataRecord() {
        assertEquals("000001,John,Doe,Mr.,1980", person.toCSVDataRecord());
    }

    @Test
    public void testSetters() {
        person.setId("000002");
        person.setFirstName("Jane");
        person.setLastName("Smith");
        person.setTitle("Ms.");
        person.setYearOfBirth(1990);

        assertEquals("000002", person.getId());
        assertEquals("Jane", person.getFirstName());
        assertEquals("Smith", person.getLastName());
        assertEquals("Ms.", person.getTitle());
        assertEquals(1990, person.getYearOfBirth());
    }
}
