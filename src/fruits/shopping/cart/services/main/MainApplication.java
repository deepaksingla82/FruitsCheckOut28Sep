/**
 * 
 */
package fruits.shopping.cart.services.main;

import java.util.Scanner;

import fruits.shopping.cart.services.ShoppingCart;
import fruits.shopping.cart.services.beans.Apple;
import fruits.shopping.cart.services.beans.Deal;
import fruits.shopping.cart.services.beans.Orange;
import fruits.shopping.cart.services.beans.Product.Type;
import fruits.shopping.cart.services.constants.ShoppingConstants;
import fruits.shopping.cart.services.impl.CheckoutServiceImpl;

/**
 * @author Deepak Singla
 *
 */
public class MainApplication {

	public static void main(String args[]) {
        // note : This Main method is just for testing the application. This can be deleted later.
        
        Scanner sc = new Scanner(System.in);
        System.out.println(" ********* Welcome to the Fruit Shop checkout System *********** ");
        
        System.out.println("Please Enter the number of APPLES : ");
        Integer appleCount = sc.nextInt();
        
        System.out.println("Please Enter the number of ORANGES :");
        Integer orangeCount = sc.nextInt();

        ShoppingCart shoppingCart = new ShoppingCart();
        
        Deal appleDeal = new Deal(ShoppingConstants.APPLE_CODE, ShoppingConstants.NUMBER_TWO);
        Deal orangeDeal = new Deal(ShoppingConstants.ORANGE_CODE, ShoppingConstants.NUMBER_THREE);
        
        for(int i=0; i<appleCount; i++){
        	shoppingCart.addProduct(new Apple(ShoppingConstants.APPLE_CODE, Type.APPLE.name(),ShoppingConstants.APPLE_PRODUCT_PRICE, appleDeal ));
        }
        
        for(int i=0; i<orangeCount; i++){
        	shoppingCart.addProduct(new Orange(ShoppingConstants.ORANGE_CODE, Type.ORANGE.name(),ShoppingConstants.ORANGE_PRODUCT_PRICE, orangeDeal ));
        }

        CheckoutServiceImpl checkOutService = new CheckoutServiceImpl();

        checkOutService.checkout(shoppingCart);
        
        System.out.println("Total Pay : "+ checkOutService.getPrice());
        System.out.println("********** Thank you for Shopping at Fruit shop *********");
    }
}
