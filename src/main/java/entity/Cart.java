package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李 on 2017/6/4.
 */
public class Cart {
    private List<CartProduct> cartProducts;

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public List<CartProduct> getCartProducts() {
        return cartProducts;
    }
}
