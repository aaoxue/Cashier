package util;

import entity.Receipt;

/**
 * print receipt
 *
 * @author lihm
 * @create 2017-06-08 下午8:56
 **/
public class PrintReceiptUtil {

    public static void print(Receipt receipt) {
        System.out.println("购物明细   （数量    单价     小计）");
        receipt.getReceiptDetails().stream().forEach(receiptDetail -> System.out.println(receiptDetail.subTotalDetailString()));
        System.out.println("总计：" + receipt.getTotalFee() + " 优惠前：" + receipt.getBeforePromotion()
                + " 优惠后：" + receipt.getAferPromotion() + " 优惠差价：" + receipt.getPromotionFee());
    }
}
