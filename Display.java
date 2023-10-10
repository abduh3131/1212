import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Display implements PropertyChangeListener {

	private Product product;

	Display () {

	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if ("product".equals(evt.getPropertyName())) {
			Product product = (Product) evt.getNewValue();
			System.out.println("Product name: " + product.getName() + " price = " + product.getPrice());
		} else if ("invalidUPC".equals(evt.getPropertyName())) {
			int invalidUPC = (int) evt.getNewValue();
			System.out.println("No product found for UPC: " + invalidUPC);
		}
	}



}
