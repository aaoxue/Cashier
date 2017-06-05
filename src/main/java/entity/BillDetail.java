package entity;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public class BillDetail {
    private ChooseProduct chooseProduct;
    private BigDecimal subTotal;

    public void setChooseProduct(ChooseProduct chooseProduct) {
        this.chooseProduct = chooseProduct;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public ChooseProduct getChooseProduct() {
        return chooseProduct;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public BigDecimal caculateSubTotal(){
        return chooseProduct.caculateBillDetail();
    }

    public void print() {
        System.out.println("product_code:"+chooseProduct.getProduct().getCode()+" price:"+chooseProduct.getProduct().getPrice()+" num:"+chooseProduct.getNum() +" subTotal:"+subTotal);
    }
}
