package entity;

import service.DiscountComputeHandler;
import service.Handler;
import service.SecondHalfPriceHandler;

import java.math.BigDecimal;

/**
 *CartProduct
 */
public class CartProduct {
    private Product product;
    private Integer num;
    private BigDecimal discountPrice;

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }

    public CartProduct(final Product product, final Integer num) {
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

    /**
     * 计算单选商品总价
     * @return
     */
    public BigDecimal calculateReceipt() {
        Handler handler = new DiscountComputeHandler();
        if (num > 1) {
            handler.setNextHandler(new SecondHalfPriceHandler());
        }
        return handler.calculateFee(this).setScale(1, BigDecimal.ROUND_CEILING);
    }

}
