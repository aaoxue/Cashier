package util;

import privilege.DiscountProduct;
import privilege.DiscountProducts;
import privilege.SecondHalfPriceProduct;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李 on 2017/6/4.
 */
public class ReadBaseDataUtils {
    public static DiscountProducts getDiscountProducts() {
        String code = "Product0001";
        BigDecimal discount = new BigDecimal("0.75");
        DiscountProduct discountProduct = new DiscountProduct(code, discount);
        DiscountProducts discountProducts = new DiscountProducts();
        List<DiscountProduct> products = new ArrayList<>();
        products.add(discountProduct);
        products.add(new DiscountProduct("BOTH00001",new BigDecimal("0.8")));
        discountProducts.setProducts(products);
        return discountProducts;
    }

    public static SecondHalfPriceProduct getSecondHalfPriceProducts(){
        SecondHalfPriceProduct secondHalfPriceProduct = new SecondHalfPriceProduct();
        List<String> productCodes = new ArrayList<>();
        productCodes.add("HALF00001");
        productCodes.add("BOTH00001");
        secondHalfPriceProduct.setProductCodes(productCodes);
        return secondHalfPriceProduct;
    }
}
