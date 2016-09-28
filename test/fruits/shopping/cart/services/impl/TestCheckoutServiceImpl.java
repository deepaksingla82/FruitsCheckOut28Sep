/**
 * 
 */
package fruits.shopping.cart.services.impl;

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
public class TestCheckoutServiceImpl {

	private CheckoutServiceImpl checkoutService= null;
	private ShoppingCart cart = null;

	@Before
    public void setUp() {
        cart = new ShoppingCart();
        checkoutService = new CheckoutServiceImpl();
    }
	
	@Test
	public void testCheckout_Null_Cart(){
		checkoutService.checkout(null);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(0.00, totalPrice);	
	}
	@Test
	public void testCheckout_Empty_Cart(){
		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(0.00, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFiveApplesWithoutOffer(){
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

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(3.00, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFourApplesWithoutOffer(){
		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(2.40, totalPrice);	
	}

	@Test
	public void testCheckout_CheckSixOrangesWithoutOffer(){
		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange6 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);
		cart.addProduct(orange6);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(1.50, totalPrice);	
	}

	@Test
	public void testCheckout_CheckTwoOrangesWithoutOffer(){
		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);

		cart.addProduct(orange1);
		cart.addProduct(orange2);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(0.50, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFiveOrangesThreeApplesWithoutOffer(){

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, null);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, null);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);
		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(3.05, totalPrice);	
	}

	/*************Unit testing with offer *************/

	@Test
	public void testCheckout_CheckFiveApplesWithOffer(){
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

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(1.80, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFourApplesOffer(){

		Deal appleDeal = new Deal(ShoppingConstants.APPLE_CODE, ShoppingConstants.NUMBER_TWO);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple4 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);

		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);
		cart.addProduct(apple4);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(1.20, totalPrice);	
	}

	@Test
	public void testCheckout_CheckSixOrangesWithOffer(){

		Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange6 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);
		cart.addProduct(orange6);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(1.00, totalPrice);	
	}

	@Test
	public void testCheckout_CheckTwoOrangesWithOffer(){

		Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);

		cart.addProduct(orange1);
		cart.addProduct(orange2);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(0.50, totalPrice);	
	}

	@Test
	public void testCheckout_CheckFiveOrangesThreeApplesWithOffer(){

		Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);
		Deal appleDeal = new Deal(ShoppingConstants.APPLE_CODE, ShoppingConstants.NUMBER_TWO);

		Orange orange1 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange2 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange3 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange4 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);
		Orange orange5 = new Orange(ShoppingConstants.ORANGE_CODE, Product.Type.ORANGE.name(), ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal);

		Apple apple1 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple2 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);
		Apple apple3 = new Apple(ShoppingConstants.APPLE_CODE, Product.Type.APPLE.name(), ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal);

		cart.addProduct(orange1);
		cart.addProduct(orange2);
		cart.addProduct(orange3);
		cart.addProduct(orange4);
		cart.addProduct(orange5);
		cart.addProduct(apple1);
		cart.addProduct(apple2);
		cart.addProduct(apple3);

		checkoutService.checkout(cart);
		double totalPrice = checkoutService.getPrice();
		Assert.assertEquals(2.20, totalPrice);	
	}


}
