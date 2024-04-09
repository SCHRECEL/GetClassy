import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class PersonReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a Person file");

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                ArrayList<Person> personList = readPersonData(selectedFile);
                displayPersonData(personList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File selection cancelled by the user.");
        }
    }

    private static ArrayList<Person> readPersonData(File file) throws IOException {
        ArrayList<Person> personList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Person person = new Person(data[0], data[1], data[2], data[3], Integer.parseInt(data[4]));
            personList.add(person);
        }

        reader.close();
        return personList;
    }

    private static void displayPersonData(ArrayList<Person> personList) {
        System.out.println(String.format("%-10s%-15s%-15s%-10s%-4s", "ID#", "Firstname", "Lastname", "Title", "YOB"));
        System.out.println("=========================================================================");

        for (Person person : personList) {
            String formattedLine = String.format("%-10s%-15s%-15s%-10s%4s",
                    person.getId(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYearOfBirth());
            System.out.println(formattedLine);
        }
    }
}
