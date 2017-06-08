package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李 on 2017/6/4.
 */
public class Cart {
    private List<CartProduct> cartProducts;
    public List<Receipt> receipts;

    public void setCartProducts(List<CartProduct> cartProducts) {
        this.cartProducts = cartProducts;
    }

    public List<Receipt> getReceipts() {
        receipts = new ArrayList<>();
        cartProducts.stream().forEach(chooseProduct -> {
            Receipt receipt = new Receipt();
            receipt.setCartProduct(chooseProduct);
            receipt.setSubTotal(chooseProduct.calculateReceipt());
            receipts.add(receipt);
        });
        return receipts;
    }
}
