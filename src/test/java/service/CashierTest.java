package service;

import entity.Cart;
import entity.ChooseProduct;
import entity.Product;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 李 on 2017/6/5.
 */
public class CashierTest {
    @Test
    public void getTotalFeeDetail() throws Exception {
        //given
        Cart cart = new Cart();
        List<ChooseProduct> chooseProducts = new ArrayList<>();
        String code = "Product0001";
        Product product = new Product(code, new BigDecimal(50.0));
        ChooseProduct chooseProduct = new ChooseProduct(product, 2);
        chooseProducts.add(chooseProduct);
        String halfCode = "HALF00001";
        Product halfProduct = new Product(halfCode, new BigDecimal(100.0));
        ChooseProduct chooseHalfProduct = new ChooseProduct(halfProduct, 3);
        chooseProducts.add(chooseHalfProduct);
        cart.setChooseProducts(chooseProducts);
        //when
        Cashier cashier = new Cashier();
        cashier.getTotalFeeDetail(cart);
        //then

    }

}