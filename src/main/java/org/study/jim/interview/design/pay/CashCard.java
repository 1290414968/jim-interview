package org.study.jim.interview.design.pay;
/**
 * @Auther: jim
 * @Date: 2018/10/7 16:54
 * @Description:
 */
public class CashCard extends CardPay {
    public String getPayWay() {
        return "cash";
    }
    public void doTransactionPay(int cents) {
        System.out.println("doTransactionPay with "+getPayWay()+"has payed :"+cents);
    }
}
