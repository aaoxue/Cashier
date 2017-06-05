package service;

import entity.Receipt;
import entity.Cart;
import entity.Total;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Cashier {
    public Total getTotalFeeDetail(Cart cart) {
        List<Receipt> receipts = cart.getReceipts();
        BigDecimal beforePromotion = BigDecimal.ZERO;
        BigDecimal afterPromotion = BigDecimal.ZERO;
        for (Receipt receipt : receipts) {
            beforePromotion = beforePromotion.add(receipt.getCartProduct().getProduct().getPrice().multiply(new BigDecimal(receipt.getCartProduct().getNum())));
            afterPromotion = afterPromotion.add(receipt.getSubTotal());
        }
        Total total = new Total(afterPromotion,beforePromotion,afterPromotion,beforePromotion.subtract(afterPromotion),receipts);
        total.print();
        return total;
    }
}
