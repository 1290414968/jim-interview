package org.study.jim.interview.design.pay;

/**
 * @Auther: jim
 * @Date: 2018/10/7 16:53
 * @Description:
 */
public abstract class CardPay implements Pay {
    public abstract String getPayWay();
    public abstract void doTransactionPay(int cents);
    public void pay(int cents) {
        System.out.println("use pay way :"+getPayWay()+"has payed :"+cents);
        doTransactionPay(cents);
    }
}
