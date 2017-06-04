package service;

import entity.ChooseProduct;
import util.ReadBaseDataUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by 李 on 2017/6/4.
 */
public class SecondHalfPriceHandler extends Handler {
    @Override
    public BigDecimal caculateFee(ChooseProduct product) {
        BigDecimal subFee;
        if (product.getNum() == 2) {
            subFee = product.getDiscountPrice().add(product.getDiscountPrice().divide(new BigDecimal("2.0"),1, RoundingMode.CEILING));
        } else {
            subFee = product.getDiscountPrice().add(product.getDiscountPrice().divide(new BigDecimal("2.0"),1, RoundingMode.CEILING).multiply(new BigDecimal(product.getNum() - 1)));
        }

        return subFee;
    }

    @Override
    public boolean condition(ChooseProduct product) {
        if (ReadBaseDataUtils.getSecondHalfPriceProducts().getProductCodes().contains(product.getProduct().getCode())) {
            return true;
        }
        return false;
    }
}
