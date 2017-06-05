package service;

import entity.ChooseProduct;

import java.math.BigDecimal;

/**
 * Created by 李 on 2017/6/4.
 */
public abstract class Handler {
    private Handler nextHandler;
    public abstract BigDecimal caculateFee(ChooseProduct product);
    public abstract boolean condition(ChooseProduct product);

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {

        this.nextHandler = nextHandler;
    }
}
