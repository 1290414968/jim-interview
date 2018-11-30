package org.study.jim.interview.dataConstruct.stackQueue;
import org.study.jim.interview.dataConstruct.linked.ListNode;
import org.study.jim.interview.dataConstruct.linked.MyListNode;

/**
 * @Auther: jim
 * @Date: 2018/11/29 22:09
 * @Description: 构造栈对象
 */
public class MyStack {
    private ListNode topStack;
    private ListNode bottomStack;
    public MyStack(ListNode topStack, ListNode bottomStack) {
        this.topStack = topStack;
        this.bottomStack = bottomStack;
    }
    //压栈
    static void push(MyStack myStack,int value){
        ListNode node = new ListNode(value);
        node.next = myStack.topStack;
        myStack.topStack = node;
    }
    //列出栈内容
    static void listStack(MyStack myStack){
        ListNode topStack = myStack.topStack;
        while (topStack!=myStack.bottomStack){
            System.out.print(topStack.value+" ");
            topStack = topStack.next;
        }
        System.out.println();
    }
    static void popStack(MyStack myStack){
        if(!isEmpty(myStack)){
            ListNode topStack =  myStack.topStack;
            myStack.topStack = topStack.next;
            System.out.println(topStack.value);
        }
    }
    static boolean isEmpty(MyStack myStack){
        if(myStack.topStack==myStack.bottomStack){
            return true;
        }else{
            return false;
        }
    }
    static void clear(MyStack myStack){
        myStack.topStack = null;
        myStack.bottomStack = myStack.topStack;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0),new ListNode(0));
        myStack.topStack = myStack.bottomStack;
        System.out.println(isEmpty(myStack));
        push(myStack,1);
        push(myStack,2);
        push(myStack,3);
        push(myStack,4);
        System.out.println(isEmpty(myStack));
        listStack(myStack);
        popStack(myStack);
        listStack(myStack);
        clear(myStack);
        System.out.println(isEmpty(myStack));
    }
}
