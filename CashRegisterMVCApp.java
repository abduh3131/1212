import java.util.ArrayList;

public class CashRegisterMVCApp {

    public static void main(String[] args) {
        // Assemble all the pieces of the Cash Register MVC
        CashRegisterModel m = new CashRegisterModel(new ArrayList <Product> ());
        Display v = new Display();
        m.addPropertyChangeListener(v);
        Keyboard c = new Keyboard("Keyboard",m);

    }

}