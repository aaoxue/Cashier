package privilege;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public class DiscountProduct {
    private String productCode;
    private BigDecimal discount;

    public DiscountProduct(String productCode, BigDecimal discount) {
        this.productCode = productCode;
        this.discount = discount;
    }

    public String getProductCode() {
        return productCode;
    }

    public BigDecimal getDiscount() {
        return discount;
    }
}
