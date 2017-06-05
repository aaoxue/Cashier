package entity;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public class Product {
    private String code;
    private BigDecimal price;

    public String getCode() {
        return code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product(String code, BigDecimal price) {
        this.code = code;
        this.price = price;
    }
}
