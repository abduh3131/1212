import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CashRegisterMVCApp {

    public static ArrayList<Product> loadProductsFromFile(String filename) {
        ArrayList<Product> products = new ArrayList<>();
        File file = new File("src/" + filename);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                int UPC = Integer.parseInt(parts[0].trim());
                String name = parts[1].trim();
                double price = Double.parseDouble(parts[2].trim());

                products.add(new Product(UPC, name, price));
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        }

        return products;
    }

    public static void main(String[] args) {
        ArrayList<Product> products = loadProductsFromFile("products.txt");
        CashRegisterModel m = new CashRegisterModel(products);
        Display v = new Display();
        m.addPropertyChangeListener(v);
        Keyboard c = new Keyboard("Keyboard", m);
    }
}
