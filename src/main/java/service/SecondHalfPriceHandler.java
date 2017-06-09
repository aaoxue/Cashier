package service;

import entity.CartProduct;
import util.ReadBaseDataUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by 李 on 2017/6/4.
 */
public class SecondHalfPriceHandler extends Handler {
    @Override
    public BigDecimal calculateFee(CartProduct product) {
        final int NUM_COUNT_TWO = 2;
        if (product.getNum() == NUM_COUNT_TWO) {
            return product.getDiscountPrice().add(product.getDiscountPrice().divide(new BigDecimal("2.0"), 1, RoundingMode.FLOOR));
        }
        return product.getDiscountPrice().add(product.getDiscountPrice().divide(new BigDecimal("2.0"), 1, RoundingMode.FLOOR).multiply(new BigDecimal(product.getNum() - 1)));
    }

    @Override
    public boolean condition(CartProduct product) {
        boolean isHalfPrice = ReadBaseDataUtils.getSecondHalfPriceProducts().getProductCodes().contains(product.getProduct().getCode());
        return isHalfPrice;
    }
}
