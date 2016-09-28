/**
 * 
 */
package fruits.shopping.cart.services.helpers;

import java.util.List;
import java.util.stream.Collectors;

import fruits.shopping.cart.services.ShoppingCart;
import fruits.shopping.cart.services.beans.Product;
import fruits.shopping.cart.services.beans.Product.Type;

/**
 * @author Deepak Singla
 *
 */
public class CheckoutServiceHelper {

	public static Double calculateOffer(ShoppingCart cart) {

		Double priceDiscount = 0.0;
		if(cart != null && cart.getProducts() != null){
			List<Product> dealProducts = cart.getProducts().stream().filter(p -> p.getDeal() != null).collect(Collectors.toList());
			if (dealProducts != null && dealProducts.size() > 0) {
				for (Type type : Type.values()) {
					List<Product> productByType = dealProducts.stream()
							.filter(product -> product.getName().equalsIgnoreCase(type.name())).collect(Collectors.toList());
					if (productByType.size() > 0) {
						Product product = productByType.get(0);
						priceDiscount += (productByType.size() / product.getDeal().getCount()) * product.getPrice();
					}
				}
			}
		}
		return priceDiscount;

	}

}
