package service;

import entity.Cart;
import entity.CartProduct;
import entity.Product;
import entity.Receipt;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * CashierTest
 */
public class CashierTest {
    @Test
    public void should_return_right_total_when_cart_has_two_different_promotion_product() throws Exception {
        //given
        Cart cart = new Cart();
        List<CartProduct> cartProducts = new ArrayList<>();
        String code = "Product0001";
        Product product = new Product(code, new BigDecimal(100.0));
        CartProduct cartProduct = new CartProduct(product, 2);
        cartProducts.add(cartProduct);
        String halfCode = "HALF00001";
        Product halfProduct = new Product(halfCode, new BigDecimal(100.0));
        CartProduct chooseHalfProduct = new CartProduct(halfProduct, 3);
        cartProducts.add(chooseHalfProduct);
        cart.setCartProducts(cartProducts);
        //when
        Cashier cashier = new Cashier();
        Receipt receipt = cashier.getTotalFeeDetail(cart);
        //then
        assertThat(receipt.getTotalFee(),is(new BigDecimal("350.0")));

    }

}