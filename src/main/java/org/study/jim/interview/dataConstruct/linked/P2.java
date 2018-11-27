package org.study.jim.interview.dataConstruct.linked;
/**
 * @Auther: jim
 * @Date: 2018/11/25 16:15
 */
public class P2 {
    /**
     * 递归的方式去合并
     * @param firstHeadNode
     * @param secondHeadNode
     * @return
     */
    static ListNode mergeList(ListNode firstHeadNode,ListNode secondHeadNode){
        if(firstHeadNode==null&&secondHeadNode==null){
            return null;
        }
        if(firstHeadNode==null){
            return secondHeadNode;
        }
        if(secondHeadNode==null){
            return firstHeadNode;
        }
        ListNode head = null;
        if(firstHeadNode.value>secondHeadNode.value){//第一个链表的值大于第二个链表的值
            head = secondHeadNode;//head设置为小值的节点
            head.next = mergeList(firstHeadNode,secondHeadNode.next);//head的下一节点，从大值到小值下一节点递归查找
        }else{
            head = firstHeadNode;//head设置为小值的节点
            head.next = mergeList(secondHeadNode,firstHeadNode.next);//head的下一节点，从大值到小值下一节点递归查找
        }
        return head;
    }

    /**
     * 非递归，使用头节点值小的链表M，将头节点值大的链表插入到M，进行合并
     * @param head1
     * @param head2
     * @return
     */
    static ListNode mergeList2(ListNode head1,ListNode head2){
        if(head1==null || head2==null){
            return head1!=null ? head1 : head2;
        }
        //设置小值为头节点
        ListNode head = head1.value< head2.value ? head1: head2;
        //变量cur1 为 head1
        ListNode cur1 = head == head1 ? head1 : head2;
        //变量cur2 为 head2
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = null;//当前节点的前一个节点
        ListNode next = null;//当前节点的下一个节点
        while (cur1!=null && cur2!=null){
            if(cur1.value<=cur2.value){//当cur1的值小于cur2的值时,将pre设置为当前节点，当前节点设置为当前节点的下一个节点
                pre = cur1;
                cur1 = cur1.next;
            }else{//当cur1的值大于cur2时，
                /**
                 * 逻辑总结：将cur2节点设置为pre的下一节点，
                 * cur1节点设置为cur2的下一节点
                 * next 设置为cur2的下一节点
                 * pre的下一节点为cur2
                 * cur2的下一节点为cur1
                 * pre 设置为cur2
                 * cur2 设置为 cur2的下一节点
                 */
                next = cur2.next;
                pre.next = cur2;
                cur2.next = cur1;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2:cur1;
        return  head;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node3;
        node2.next = node4;
        MyListNode.list(mergeList2(node1,node2));
    }
}
