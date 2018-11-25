package org.study.jim.interview.design.pay;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:06
 * @Description:
 */
public class PayFactory {
    public static Pay getPay(String payWay){
        if("credit".equals(payWay)){
            return new CreditCard();
        }else  if("cash".equals(payWay)){
            return new CashCard();
        }else {
            throw new RuntimeException("pay error");
        }
    }
}
