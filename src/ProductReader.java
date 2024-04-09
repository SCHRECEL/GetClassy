import javax.swing.JFileChooser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ProductReader {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select a Product file");

        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                ArrayList<Product> productList = readProductData(selectedFile);
                displayProductData(productList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File selection cancelled");
        }
    }

    private static ArrayList<Product> readProductData(File file) throws IOException {
        ArrayList<Product> productList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            Product product = new Product(data[0], data[1], data[2], Double.parseDouble(data[3]));
            productList.add(product);
        }

        reader.close();
        return productList;
    }

    private static void displayProductData(ArrayList<Product> productList) {
        System.out.println(String.format("%-10s%-20s%-30s%-10s", "ID#", "Name", "Description", "Cost"));
        System.out.println("=========================================================================");

        for (Product product : productList) {
            String formattedLine = String.format("%-10s%-20s%-30s$%-10.2f",
                    product.getId(), product.getName(), product.getDescription(), product.getCost());
            System.out.println(formattedLine);
        }
    }
}
