package org.study.jim.interview.dataConstruct.linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: jim
 * @Date: 2018/11/28 22:50
 * @Description:
 * 链表结构如下：1 8 3 6 5 4 7 2 9
 * 进行排序
 */
public class P3 {
    /**
     * 实现步骤：
     * 1、根据奇偶数进行拆分成两个链表
     * 2、将偶数链表进行反转排序
     * 3、将奇数链表和偶数链表进行合并
     */
    static List<ListNode> split(ListNode head){
        ListNode oddHead = null;//奇数头节点
        ListNode evenHead = null;//偶数头节点

        ListNode oddCur = null;//当前奇数
        ListNode evenCur = null;//当前偶数
        int count = 1;

        while (head!=null){
            if(count%2 == 1){//偶数
               if(evenCur!=null){
                   evenCur.next = head;//当前偶数的next为循环的head节点
                   evenCur = evenCur.next;//当前偶数为next节点，当进行下一次循环时关联链接节点
               }else{
                   evenCur = head;
                   evenHead = evenCur;
               }
            }else{
                if(oddCur!=null){
                    oddCur.next = head;
                    oddCur = oddCur.next;
                }else{
                    oddCur = head;
                    oddHead = oddCur;
                }
            }
            head = head.next;
            count++;
        }
        //两个链表截断
        evenCur.next = null;
        oddCur.next = null;
        List<ListNode> nodes = new ArrayList<>();
        nodes.add(evenHead);
        nodes.add(oddHead);
        return nodes;
    }
    static ListNode reverse(ListNode evenHead){
        ListNode pre = null;
        ListNode next = null;
        while (evenHead!=null){
            next = evenHead.next;
            evenHead.next  = pre;
            pre = evenHead;
            evenHead = next;
        }
        return pre;
    }
    static ListNode merge(ListNode head1,ListNode head2){
        ListNode head = null;
        if(head1==null && head2==null){
            return null;
        }
        if(head1==null){
            return head2;
        }
        if(head2==null){
            return head1;
        }
        if(head1.value<head2.value){
            head = head1;
            head.next = merge(head1.next,head2);
        }else{
            head = head2;
            head.next = merge(head2.next,head1);
        }
        return head;
    }

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

        List<ListNode> nodes  = split(node1);
        ListNode oddNodeHead = reverse(nodes.get(1));
        ListNode head = merge(nodes.get(0),oddNodeHead);
        MyListNode.list(head);
    }
}
