package entity;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/5.
 */
public class Total {
    private BigDecimal totalFee;
    private BigDecimal beforePromotion;
    private BigDecimal aferPromotion;
    private BigDecimal promotionFee;

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getBeforePromotion() {
        return beforePromotion;
    }

    public void setBeforePromotion(BigDecimal beforePromotion) {
        this.beforePromotion = beforePromotion;
    }

    public BigDecimal getAferPromotion() {
        return aferPromotion;
    }

    public void setAferPromotion(BigDecimal aferPromotion) {
        this.aferPromotion = aferPromotion;
    }

    public BigDecimal getPromotionFee() {
        return promotionFee;
    }

    public void setPromotionFee(BigDecimal promotionFee) {
        this.promotionFee = promotionFee;
    }

    public void print() {
        System.out.println("总计："+totalFee+" 优惠前："+beforePromotion+" 优惠后："+ aferPromotion+" 优惠差价："+promotionFee);
    }
}
