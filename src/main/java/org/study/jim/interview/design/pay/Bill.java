package org.study.jim.interview.design.pay;
import java.util.ArrayList;
import java.util.List;
/**
 * @Auther: jim
 * @Date: 2018/10/7 17:01
 * @Description:
 */
public class Bill {
    private List<Item> itemList = new ArrayList<>();
    public void addItem(Item item){
        itemList.add(item);
    }
    public void removeItem(Item item){
        itemList.remove(item);
    }
    public int count(){
        return itemList.stream().mapToInt(Item::getCents).sum();
    }
    public void pay(Pay pay){
        pay.pay(count());
    }
}
