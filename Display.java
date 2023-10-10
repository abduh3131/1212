// This is an example of a view. In this case we will simply print out the product name and price
// We use the PropertyChangeListener to get notificaitons from the cash register

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Display implements PropertyChangeListener {

    private Product product;

    Display () {

    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("product".equals(evt.getPropertyName())) {
            product = (Product) evt.getNewValue();
            System.out.println("Product name: " + product.getName() + " price = $ " + product.getPrice());
        } else if ("invalidUPC".equals(evt.getPropertyName())) {
            System.out.println("No product found for UPC: " + evt.getNewValue());
        }
    }}
