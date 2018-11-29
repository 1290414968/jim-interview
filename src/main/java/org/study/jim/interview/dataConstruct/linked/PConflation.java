package org.study.jim.interview.dataConstruct.linked;

import java.util.List;

/**
 * @Auther: jim
 * @Date: 2018/11/29 09:15
 * @Description:
 */
public class PConflation {

    /**
     * 1、先将排序的链表取中间值一分为二
     * 2、递归左半部分排序
     * 3、递归右半部分排序
     * 4、将左右排序的链表进行合并
     */
    public static void main(String[] args) {
        //链表结构如下：1 8 3 6 5 4 7 2 9
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node9;
        node9.next=null;
        node1 = sortList(node1);
        MyListNode.list(node1);
    }
    static ListNode sortList(ListNode head){
        if(head==null || head.next== null){
            return head;
        }
        //2-3、左右部分的分治合并
        ListNode mid = midSpit(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode node = merge(sortList(head),sortList(right));
        return node;
    }
    //1、先将排序的链表取中间值一分为二
    static ListNode midSpit(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //4、将左右排序的链表进行合并
    static ListNode merge(ListNode left,ListNode right){
        if(left==null&&right==null){
            return null;
        }
        if(left==null){
            return right;
        }
        if(right==null){
            return left;
        }
        ListNode head = null;
        if(left.value>right.value){//第一个链表的值大于第二个链表的值
            head = right;//head设置为小值的节点
            head.next = merge(left,right.next);//head的下一节点，从大值到小值下一节点递归查找
        }else{
            head = left;//head设置为小值的节点
            head.next = merge(right,left.next);//head的下一节点，从大值到小值下一节点递归查找
        }
        return head;
    }

}
