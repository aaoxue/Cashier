package service;

import entity.ReceiptDetail;
import entity.Cart;
import entity.Receipt;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Cashier {
    public Receipt getTotalFeeDetail(Cart cart) {
        List<ReceiptDetail> receipts = cart.getReceipts();
        BigDecimal beforePromotion = BigDecimal.ZERO;
        BigDecimal afterPromotion = BigDecimal.ZERO;
        for (ReceiptDetail receipt : receipts) {
            beforePromotion = beforePromotion.add(receipt.getCartProduct().getProduct().getPrice().multiply(new BigDecimal(receipt.getCartProduct().getNum())));
            afterPromotion = afterPromotion.add(receipt.getSubTotal());
        }
        Receipt total = new Receipt(afterPromotion,beforePromotion,afterPromotion,beforePromotion.subtract(afterPromotion),receipts);
        total.print();
        return total;
    }
}
