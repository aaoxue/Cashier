package entity;

import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by 李 on 2017/6/4.
 */
public class ChooseProductTest {
    @Test
    public void should_return_right_discount_price_when_product_in_discount_list() {
        //given
        String code = "Product0001";
        BigDecimal discount = new BigDecimal(0.75);
        Product product = new Product(code, new BigDecimal(50.0));
        ChooseProduct chooseProduct = new ChooseProduct(product, 1);
        //when
        BigDecimal result = chooseProduct.caculateBillDetail();
        //then
        assertThat(result, is(product.getPrice().multiply(discount).setScale(1)));

    }

    @Test
    public void should_return_half_price_when_cart_has_two_product_which_in_half_list() throws Exception {
        //given
        String code = "HALF00001";
        Product product = new Product(code, new BigDecimal(100.0));
        ChooseProduct chooseProduct = new ChooseProduct(product, 2);
        //when
        BigDecimal result = chooseProduct.caculateBillDetail();
        //then
        assertThat(result, is(new BigDecimal("150.0")));
    }

    @Test
    public void should_return_half_price_expect_one_product_when_cart_has_three_product_which_in_half_list() throws Exception {
        //given
        String code = "HALF00001";
        Product product = new Product(code, new BigDecimal(100.0));
        ChooseProduct chooseProduct = new ChooseProduct(product, 3);
        //when
        BigDecimal result = chooseProduct.caculateBillDetail();
        //then
        assertThat(result, is(new BigDecimal("200.0")));
    }

    @Test
    public void should_return_right_price_when_cart_has_one_product_which_in_half_list_and_discount_list() throws Exception {
//given
        String code = "BOTH00001";
        Product product = new Product(code, new BigDecimal("100.0"));
        ChooseProduct chooseProduct = new ChooseProduct(product, 2);
        //when
        BigDecimal result = chooseProduct.caculateBillDetail();
        //then
        assertThat(result, is(new BigDecimal("120.0")));
    }
}