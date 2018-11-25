package org.study.jim.interview.design.pay;

/**
 * @Auther: jim
 * @Date: 2018/10/7 17:01
 * @Description:
 */
public class Item {
    private String name;
    private int cents;

    public Item(String name, int cents) {
        this.name = name;
        this.cents = cents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCents() {
        return cents;
    }

    public void setCents(int cents) {
        this.cents = cents;
    }
}
