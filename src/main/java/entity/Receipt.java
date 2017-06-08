package entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by 李 on 2017/6/5.
 */
public class Receipt {
    private BigDecimal totalFee;
    private BigDecimal beforePromotion;
    private BigDecimal aferPromotion;
    private BigDecimal promotionFee;

    public void setReceiptDetails(List<ReceiptDetail> receiptDetails) {
        this.receiptDetails = receiptDetails;
    }

    private List<ReceiptDetail> receiptDetails;

    public List<ReceiptDetail> getReceiptDetails() {
        return receiptDetails;
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public BigDecimal getBeforePromotion() {
        return beforePromotion;
    }

    public BigDecimal getAferPromotion() {
        return aferPromotion;
    }

    public BigDecimal getPromotionFee() {
        return promotionFee;
    }

    public Receipt() {
    }

    public Receipt(BigDecimal totalFee, BigDecimal beforePromotion, BigDecimal aferPromotion, BigDecimal promotionFee, List<ReceiptDetail> receiptDetails) {
        this.totalFee = totalFee;
        this.beforePromotion = beforePromotion;
        this.aferPromotion = aferPromotion;
        this.promotionFee = promotionFee;
        this.receiptDetails = receiptDetails;
    }

}
