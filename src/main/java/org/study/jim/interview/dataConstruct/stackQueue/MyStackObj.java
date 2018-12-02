package org.study.jim.interview.dataConstruct.stackQueue;
import org.study.jim.interview.dataConstruct.linked.ListNode;
import org.study.jim.interview.dataConstruct.linked.MyListNode;

/**
 * @Auther: jim
 * @Date: 2018/11/29 22:09
 * @Description: 构造栈对象
 */
public class MyStackObj {
    private ListNode topStack ;
    private ListNode bottomStack;

    public MyStackObj(ListNode topStack, ListNode bottomStack) {
        this.topStack = topStack;
        this.bottomStack = bottomStack;
    }

    //压栈
    void push(int value){
        ListNode node = new ListNode(value);
        node.next = this.topStack;
        this.topStack = node;
    }
    int peek(){
        if(!isEmpty()){
            return this.topStack.value;
        }
        return 0;
    }
    int pop(){
        if(!isEmpty()){
            this.topStack = this.topStack.next;
            return topStack.value;
        }
        return 0;
    }
    boolean isEmpty() {
        if (topStack.next == null) {
            return true;
        } else {
            return false;
        }
    }
}
