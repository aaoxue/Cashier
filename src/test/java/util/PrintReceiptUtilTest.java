package util;

import entity.CartProduct;
import entity.Product;
import entity.Receipt;
import entity.ReceiptDetail;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;

/**
 * Created by Mac on 17/6/8.
 */
public class PrintReceiptUtilTest {
    @Test
    public void should_print_right_style_when_has_sub_receipt() throws Exception {
        //given
        ReceiptDetail receiptDetail = mock(ReceiptDetail.class);
        Receipt receipt = new Receipt();
        List<ReceiptDetail> receiptDetails = new ArrayList<>();
        ReceiptDetail receiptData = new ReceiptDetail();
        receiptData.setSubTotal(BigDecimal.ZERO);
        Product product = new Product("TEST0001", BigDecimal.TEN);
        CartProduct cartProduct = new CartProduct(product, 2);
        receiptData.setCartProduct(cartProduct);
        receiptData.setSubTotal(BigDecimal.TEN);
        receiptDetails.add(receiptDetail);
        receiptDetails.add(receiptData);
        receipt.setReceiptDetails(receiptDetails);
        //when
        PrintReceiptUtil.print(receipt);

    }

}