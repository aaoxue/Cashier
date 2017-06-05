package entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * CartProductTest
 */
public class CartProductTest {
    @Test
    public void should_return_right_discount_price_when_product_in_discount_list() {
        //given
        String code = "Product0001";
        BigDecimal discount = new BigDecimal(0.75);
        Product product = new Product(code, new BigDecimal(50.0));
        CartProduct cartProduct = new CartProduct(product, 1);
        //when
        BigDecimal result = cartProduct.calculateReceipt();
        //then
        assertThat(result, is(product.getPrice().multiply(discount).setScale(1, RoundingMode.CEILING)));

    }

    @Test
    public void should_return_half_price_when_cart_has_two_product_which_in_half_list() throws Exception {
        //given
        String code = "HALF00001";
        Product product = new Product(code, new BigDecimal(100.0));
        CartProduct cartProduct = new CartProduct(product, 2);
        //when
        BigDecimal result = cartProduct.calculateReceipt();
        //then
        assertThat(result, is(new BigDecimal("150.0")));
    }

    @Test
    public void should_return_half_price_expect_one_product_when_cart_has_three_product_which_in_half_list() throws Exception {
        //given
        String code = "HALF00001";
        Product product = new Product(code, new BigDecimal(100.0));
        CartProduct cartProduct = new CartProduct(product, 3);
        //when
        BigDecimal result = cartProduct.calculateReceipt();
        //then
        assertThat(result, is(new BigDecimal("200.0")));
    }

    @Test
    public void should_return_right_total_fee_when_product_has_no_promotion() throws Exception {
        //given
        String code = "NOPROMOTION00001";
        Product product = new Product(code, new BigDecimal("100.0"));
        CartProduct cartProduct = new CartProduct(product, 2);
        //when
        BigDecimal result = cartProduct.calculateReceipt();
        //then
        assertThat(result, is(new BigDecimal("200.0")));
    }

    @Test
    public void should_return_right_price_when_cart_has_one_product_which_in_half_list_and_discount_list() throws Exception {
        //given
        String code = "BOTH00001";
        Product product = new Product(code, new BigDecimal("100.0"));
        CartProduct cartProduct = new CartProduct(product, 2);
        //when
        BigDecimal result = cartProduct.calculateReceipt();
        //then
        assertThat(result, is(new BigDecimal("120.0")));
    }
}