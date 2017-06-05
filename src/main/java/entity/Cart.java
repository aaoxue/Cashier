package entity;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

/**
 * Created by 李 on 2017/6/4.
 */
public class Cart {
    private List<ChooseProduct> chooseProducts;
    public List<BillDetail> billDetails;

    public List<ChooseProduct> getChooseProducts() {
        return chooseProducts;
    }

    public void setChooseProducts(List<ChooseProduct> chooseProducts) {
        this.chooseProducts = chooseProducts;
    }

    public List<BillDetail> getBillDetails() {
        List<BillDetail> billDetails = new ArrayList<>();
        chooseProducts.stream().forEach(chooseProduct -> {
            BillDetail billDetail = new BillDetail();
            billDetail.setChooseProduct(chooseProduct);
            billDetail.setSubTotal(chooseProduct.caculateBillDetail());
            billDetail.print();
            billDetails.add(billDetail);
        });
        return billDetails;
    }

    public void setBillDetails(List<BillDetail> billDetails) {
        this.billDetails = billDetails;
    }
}
