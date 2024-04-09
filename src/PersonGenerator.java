import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    private static ArrayList<Person> personList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        readPersonDataFromInput();
        writePersonDataToFile();
    }

    private static void readPersonDataFromInput() {
        do {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String firstName = SafeInput.getNonZeroLenString(scanner, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(scanner, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(scanner, "Enter Title");
            int yearOfBirth = SafeInput.getRangedInt(scanner, "Enter Year of Birth", 1900, 2022);

            Person person = new Person(id, firstName, lastName, title, yearOfBirth);
            personList.add(person);

            System.out.println("Person data added.");

        } while (isAddingNewPerson());
    }

    private static boolean isAddingNewPerson() {
        return SafeInput.getYNConfirm(scanner, "Do you want to enter more people?");
    }

    private static void writePersonDataToFile() {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\PersonWriteData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Person person : personList) {
                writer.write(person.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Person data file written");
            System.out.println("Written to " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
