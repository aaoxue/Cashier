package service;

import entity.ReceiptDetail;
import entity.Cart;
import entity.Receipt;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Cashier {
    public Receipt getTotalFeeDetail(Cart cart) {
        List<ReceiptDetail> receipts = getReceiptDetails(cart);
        BigDecimal beforePromotion = BigDecimal.ZERO;
        BigDecimal afterPromotion = BigDecimal.ZERO;
        for (ReceiptDetail receipt : receipts) {
            beforePromotion = beforePromotion.add(receipt.getCartProduct().getProduct().getPrice().multiply(new BigDecimal(receipt.getCartProduct().getNum())));
            afterPromotion = afterPromotion.add(receipt.getSubTotal());
        }
        Receipt receipt = new Receipt(afterPromotion, beforePromotion, afterPromotion, beforePromotion.subtract(afterPromotion), receipts);
        return receipt;
    }

    private List<ReceiptDetail> getReceiptDetails(Cart cart) {
        List<ReceiptDetail> receiptDetails = new ArrayList<>();
        cart.getCartProducts().stream().forEach(cardProduct -> {
            ReceiptDetail receipt = new ReceiptDetail();
            receipt.setCartProduct(cardProduct);
            receipt.setSubTotal(cardProduct.calculateReceipt());
            receiptDetails.add(receipt);
        });
        return receiptDetails;
    }
}
