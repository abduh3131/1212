import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CashRegisterModel {

    private PropertyChangeSupport observables;
    private ArrayList<Product> myProducts;

    CashRegisterModel (ArrayList<Product> products) {
        myProducts=products;
        observables = new PropertyChangeSupport(this);
    }

    // CashRegisterModel.java

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observables.addPropertyChangeListener(pcl);
    }

    public void processUPC(int code) {
        for (Product product : myProducts) {
            if (product.getUPC() == code) {
                observables.firePropertyChange("product", null, product);
                return;
            }
        }
        observables.firePropertyChange("invalidUPC", null, code);
    }



    public ArrayList<Product>	getProductList() {
        return this.myProducts;
    }

}