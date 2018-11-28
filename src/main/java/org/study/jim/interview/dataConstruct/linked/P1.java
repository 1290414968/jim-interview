package org.study.jim.interview.dataConstruct.linked;
import java.util.List;
/**
 * @Auther: jim
 * @Date: 2018/11/25 14:34
 * @Description:
 */
public class P1 {
    /**
     * 单链表反转
     * @param headNode
     */
    static ListNode reverse(ListNode headNode){
        ListNode pre = null; //当前节点的前一个节点对象
        ListNode next = null; //当前节点的下一个节点对象
        while (headNode!=null){
            next = headNode.next;//next赋值为head的下一个
            headNode.next = pre;//head的下一个为pre
            pre = headNode;//pre赋值为当前节点
            headNode = next;//head为下一个，继续循环
        }
        return pre;
    }
    static ListNode reverse2(ListNode head){
        ListNode pre = null;
        ListNode next = null;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            //head 为下一个节点继续循环
            head = next;
        }
        return pre;
    }
    /**
     * 链表取中间值，按照快索引的步长为慢索引的步长的两倍来取值处理
     * @param headNode
     * @return
     */
    static ListNode getMid(ListNode headNode){
        if(headNode==null) return headNode;
        ListNode fast = headNode;
        ListNode slow = headNode;
        while (fast.next!=null&&fast.next.next!=null){
            slow = headNode.next;
            fast = headNode.next.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        MyListNode.list(node1);
        reverse(node1);
        MyListNode.list(node3);
        System.out.println(getMid(node3).value);
    }
}
