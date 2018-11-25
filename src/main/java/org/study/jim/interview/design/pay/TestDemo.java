package org.study.jim.interview.design.pay;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:04
 * @Description:
 */
public class TestDemo {
    public static void main(String[] args) {
        Bill bill = new Bill();
        bill.addItem(new Item("jvm",1000));
        bill.addItem(new Item("redis",2000));
        bill.pay(PayFactory.getPay("credit"));
    }
}
