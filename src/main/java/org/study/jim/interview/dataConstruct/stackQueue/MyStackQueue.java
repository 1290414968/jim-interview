package org.study.jim.interview.dataConstruct.stackQueue;

import org.study.jim.interview.dataConstruct.linked.ListNode;

/**
 * @Auther: jim
 * @Date: 2018/12/2 11:07
 * @Description:
 */
public class MyStackQueue {
    public  MyStackObj stackPush;
    public  MyStackObj stackPop;

    public MyStackQueue(MyStackObj stackPush, MyStackObj stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }
    void add(int value){
        stackPush.push(value);
    }
    int pop(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("xx");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }
    int peek(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw new RuntimeException("xx");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        MyStackQueue myStackQueue  = new MyStackQueue(new MyStackObj(node,node),new MyStackObj(node,node));
        myStackQueue.add(1);
        myStackQueue.add(2);
        myStackQueue.add(3);
        System.out.println(myStackQueue.pop());
        System.out.println(myStackQueue.pop());
        System.out.println(myStackQueue.peek());
    }
}
