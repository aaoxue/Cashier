package service;

import entity.BillDetail;
import entity.Cart;
import entity.Total;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Cashier {
    public Total getTotalFeeDetail(Cart cart) {
        List<BillDetail> billDetails = cart.getBillDetails();
        BigDecimal beforePromotion = BigDecimal.ZERO;
        BigDecimal afterPromotion = BigDecimal.ZERO;
        for (BillDetail billDetail : billDetails) {
            beforePromotion = beforePromotion.add(billDetail.getChooseProduct().getProduct().getPrice().multiply(new BigDecimal(billDetail.getChooseProduct().getNum())));
            afterPromotion = afterPromotion.add(billDetail.getSubTotal());
        }

        Total total = new Total();
        total.setTotalFee(afterPromotion);
        total.setBeforePromotion(beforePromotion);
        total.setAferPromotion(afterPromotion);
        total.setPromotionFee(beforePromotion.subtract(afterPromotion));
        total.print();
        return total;
    }
}
