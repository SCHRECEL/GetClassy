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

public class ProductGenerator {
    private static ArrayList<Product> productList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        readProductDataFromInput();
        writeProductDataToFile();
    }

    private static void readProductDataFromInput() {
        do {
            String id = SafeInput.getNonZeroLenString(scanner, "Enter ID");
            String name = SafeInput.getNonZeroLenString(scanner, "Enter Name");
            String description = SafeInput.getNonZeroLenString(scanner, "Enter Description");
            double cost = SafeInput.getDouble(scanner, "Enter Cost");

            Product product = new Product(id, name, description, cost);
            productList.add(product);

            System.out.println("Product data added.");

        } while (isAddingNewProduct());
    }

    private static boolean isAddingNewProduct() {
        return SafeInput.getYNConfirm(scanner, "Do you want to enter more products?");
    }

    private static void writeProductDataToFile() {
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\ProductWriteData.txt");

        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for (Product product : productList) {
                writer.write(product.toCSVDataRecord());
                writer.newLine();
            }
            writer.close();
            System.out.println("Product data file written");
            System.out.println("Written to " + file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
