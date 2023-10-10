import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class CashRegisterMVCApp {

    public static void main(String[] args) {
        // Assemble all the pieces of the Cash Register MVC
        ArrayList<Product> product = loadProductsFromFile("src/products.txt");
        ArrayList<Product> products = new ArrayList<>();

        CashRegisterModel m = new CashRegisterModel(new ArrayList <Product> ());
        Display v = new Display();
        m.addPropertyChangeListener(v);
        Keyboard c = new Keyboard("Keyboard",m);

    }

    public static ArrayList<Product> loadProductsFromFile(String filename) {
        ArrayList<Product> products = new ArrayList<>();

        try (Scanner scanner = new Scanner(new File("src/products.txt"))) {
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

    }

