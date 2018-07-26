package tests;

import org.testng.annotations.Test;

public class Task_19 extends TestBase {

    @Test
    public void execute() {
        app.addProductToCart();
        app.addProductToCart();
        app.addProductToCart();
        app.checkout();
        app.removeItemsFromCart();
    }
}
