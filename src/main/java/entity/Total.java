package entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Total {
    private BigDecimal totalFee;
    private BigDecimal beforePromotion;
    private BigDecimal aferPromotion;
    private BigDecimal promotionFee;

    public void setReceipts(List<Receipt> receipts) {
        this.receipts = receipts;
    }

    private List<Receipt> receipts;

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public void setBeforePromotion(BigDecimal beforePromotion) {
        this.beforePromotion = beforePromotion;
    }

    public void setAferPromotion(BigDecimal aferPromotion) {
        this.aferPromotion = aferPromotion;
    }

    public void setPromotionFee(BigDecimal promotionFee) {
        this.promotionFee = promotionFee;
    }

    public Total() {
    }

    public Total(BigDecimal totalFee, BigDecimal beforePromotion, BigDecimal aferPromotion, BigDecimal promotionFee, List<Receipt> receipts) {
        this.totalFee = totalFee;
        this.beforePromotion = beforePromotion;
        this.aferPromotion = aferPromotion;
        this.promotionFee = promotionFee;
        this.receipts = receipts;
    }

    public void print() {
        System.out.println("购物明细   （数量    单价     小计）");
        receipts.stream().forEach(receipt -> System.out.println(receipt.subTotalDetailString()));
        System.out.println("总计：" + totalFee + " 优惠前：" + beforePromotion + " 优惠后：" + aferPromotion + " 优惠差价：" + promotionFee);
    }
}
