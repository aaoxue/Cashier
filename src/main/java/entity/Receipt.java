package entity;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public class Receipt {
    private CartProduct cartProduct;
    private BigDecimal subTotal;

    public void setCartProduct(CartProduct cartProduct) {
        this.cartProduct = cartProduct;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public CartProduct getCartProduct() {
        return cartProduct;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public String subTotalDetailString() {
        return cartProduct.getProduct().getCode()+"    "+ cartProduct.getNum()+"     "+ cartProduct.getProduct().getPrice()+"    "+ cartProduct.getNum() +"    "+subTotal;
    }
}
