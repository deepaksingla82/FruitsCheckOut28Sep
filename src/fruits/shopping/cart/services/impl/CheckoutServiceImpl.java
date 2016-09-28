package fruits.shopping.cart.services.impl;

import fruits.shopping.cart.services.CheckoutService;
import fruits.shopping.cart.services.ShoppingCart;
import fruits.shopping.cart.services.helpers.CheckoutServiceHelper;

/**
 * The class implementation for Checkout interface services.
 * 
 * @author Deepak Singla
 *
 */
public class CheckoutServiceImpl implements CheckoutService {
	
	private Double totalPrice;

	@Override
    public void checkout(ShoppingCart cart) {
    	if(cart != null){
    		totalPrice = cart.getTotalCartValue();
    		totalPrice = totalPrice - CheckoutServiceHelper.calculateOffer(cart);
    	}
    }

	/**
	 * This API formats the price into 2 decimal places.
	 * 
	 * @return Double - value with 2 decimal places.
	 */
    public Double getPrice() {
    	if(totalPrice == null){
    		return 0.00;
    	}else{
    		return new Double(String.format("%.2f", totalPrice));
    	}
    }

}
