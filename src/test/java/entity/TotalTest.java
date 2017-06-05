package entity;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *Total test
 */
public class TotalTest {
    @Test
    public void should_print_right_style_when_has_sub_receipt() throws Exception {
        //given
        Receipt receipt = mock(Receipt.class);
        Total total = new Total();
        List<Receipt> receipts = new ArrayList<>();
        Receipt receiptData = new Receipt();
        receiptData.setSubTotal(BigDecimal.ZERO);
        Product product = new Product("TEST0001", BigDecimal.TEN);
        CartProduct cartProduct = new CartProduct(product, 2);
        receiptData.setCartProduct(cartProduct);
        receiptData.setSubTotal(BigDecimal.TEN);
        receipts.add(receipt);
        receipts.add(receiptData);
        total.setReceipts(receipts);
        //when
        total.print();
        //then
        verify(receipt).subTotalDetailString();
    }

}