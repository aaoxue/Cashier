package entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * CartTest
 */
public class CartTest {
    @Test
    public void should_return_right_total_fee_when_cart_has_more_product_with_two_different_promotion() throws Exception {
        //given
        Cart cart = new Cart();
        List<CartProduct> cartProducts = new ArrayList<>();
        String code = "Product0001";
        Product product = new Product(code, new BigDecimal(50.0));
        CartProduct cartProduct = new CartProduct(product, 2);
        cartProducts.add(cartProduct);
        String halfCode = "HALF00001";
        Product halfProduct = new Product(halfCode, new BigDecimal(100.0));
        CartProduct chooseHalfProduct = new CartProduct(halfProduct, 3);
        cartProducts.add(chooseHalfProduct);
        cart.setCartProducts(cartProducts);
        //when
        List<ReceiptDetail> receipts = cart.getReceipts();
        //then
        assertThat(receipts.size(),is(2));

    }

}