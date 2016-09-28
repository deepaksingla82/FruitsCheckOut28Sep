/**
 * 
 */
package fruits.shopping.cart.services.helpers;

import org.junit.Before;
import org.junit.Test;

import fruits.shopping.cart.services.ShoppingCart;
import fruits.shopping.cart.services.beans.Apple;
import fruits.shopping.cart.services.beans.Deal;
import fruits.shopping.cart.services.beans.Orange;
import fruits.shopping.cart.services.beans.Product;
import fruits.shopping.cart.services.constants.ShoppingConstants;
import junit.framework.Assert;

/**
 * @author Deepak Singla
 *
 */
public class TestCheckoutServiceHelper {

	private ShoppingCart cart = null;

	@Before
    public void setUp() {
        cart = new ShoppingCart();
    }

	@Test
	public void testCalculateOffer_Null_Cart(){

		double offerPrice = CheckoutServiceHelper.calculateOffer(null);
		Assert.assertEquals(0.00, offerPrice);	
	}
	@Test
	public void testCalculateOffer_AppleWithoutOffer_Cart(){
		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple5 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);
		cart.addProduct(apple5);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(0.00, totalPrice);	
	}

	@Test
	public void testCalculateOffer_AppleWithOffer_Cart(){

		Deal appleDeal = new Deal(ShoppingConstants.APPLE_CODE, ShoppingConstants.NUMBER_TWO);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple5 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);
		cart.addProduct(apple5);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(1.20, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFiveOrangesWithoutOffer(){

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(0.00, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFiveOrangesWithOffer(){
		Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(0.25, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFourOrangesFourApplesWithoutOffer(){

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(0.00, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFourOrangesFourApplesWithOffer(){

		Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);
		Deal appleDeal = new Deal(ShoppingConstants.APPLE_CODE, ShoppingConstants.NUMBER_TWO);

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);

		double totalPrice = CheckoutServiceHelper.calculateOffer(cart);
		Assert.assertEquals(1.45, totalPrice);	
	}

}
