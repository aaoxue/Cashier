package entity;

import service.DiscountComputeHandler;
import service.Handler;
import service.SecondHalfPriceHandler;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public class ChooseProduct {
    private Product product;
    private Integer num;
    private BigDecimal discountPrice;

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public ChooseProduct(Product product, Integer num) {
        this.product = product;
        this.num = num;
        this.discountPrice = product.getPrice();
    }

    public Product getProduct() {
        return product;
    }

    public Integer getNum() {
        return num;
    }

    public BigDecimal caculateBillDetail() {
        Handler handler = new DiscountComputeHandler();
        if (num > 1) {
            handler.setNextHandler(new SecondHalfPriceHandler());
        }
        return handler.caculateFee(this).setScale(1,BigDecimal.ROUND_CEILING);
    }

}
