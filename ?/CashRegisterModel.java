import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class CashRegisterModel {

	private PropertyChangeSupport observables;
	private ArrayList<Product> myProducts;
	private Product currentProduct;

	CashRegisterModel (ArrayList<Product> products) {
		myProducts = products;
		observables = new PropertyChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener pcl) {
		observables.addPropertyChangeListener(pcl);
	}

	public void processUPC(int code) {
		Product oldProduct = currentProduct;
		currentProduct = null;

		// use UPC to look up product and price
		for (Product product : myProducts) {
			if (product.getUPC() == code) {
				currentProduct = product;
				break;
			}
		}

		// Notify observers
		if (currentProduct != null) {
			if (!currentProduct.equals(oldProduct)) {
				observables.firePropertyChange("product", oldProduct, currentProduct);
			}
		} else {
			// Notify observers that no matching product was found
			observables.firePropertyChange("invalidUPC", null, code);
		}
	}


	public ArrayList<Product> getProductList() {
		return this.myProducts;
	}
}
