package service;

import entity.CartProduct;
import org.apache.commons.lang.ObjectUtils;
import privilege.DiscountProduct;
import privilege.DiscountProducts;
import util.ReadBaseDataUtils;

import java.math.BigDecimal;
import java.util.Optional;

/**
 * Created by 李 on 2017/6/4.
 */
public class DiscountComputeHandler extends Handler {
    DiscountProducts discountProducts = ReadBaseDataUtils.getDiscountProducts();

    @Override
    public BigDecimal calculateFee(CartProduct product) {
        BigDecimal subtotal;
        if (condition(product)) {
            Optional<DiscountProduct> optional = discountProducts.getProducts().stream().filter(tempProduct -> tempProduct.getProductCode().equals(product.getProduct().getCode())).findFirst();
            if (optional.isPresent()) {
                product.setDiscountPrice(optional.get().getDiscount().multiply(product.getProduct().getPrice()));
            }
        }
        if (ObjectUtils.notEqual(getNextHandler(), null) && getNextHandler().condition(product)) {
            return getNextHandler().calculateFee(product);
        }
        return product.getDiscountPrice().multiply(new BigDecimal(product.getNum()));
    }

    @Override
    public boolean condition(CartProduct product) {
        if (ObjectUtils.notEqual(null, discountProducts)) {
            Optional<DiscountProduct> optional = discountProducts.getProducts().stream().filter(tempProduct -> tempProduct.getProductCode().equals(product.getProduct().getCode())).findFirst();
            return optional.isPresent();
        }
        return false;
    }
}
