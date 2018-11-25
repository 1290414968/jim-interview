package org.study.jim.interview.dataConstruct.linked;
/**
 * @Auther: jim
 * @Date: 2018/11{
 *
 *         return null;
 *     }/25 16:15
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
        ListNode cur1 = head == head1 ? head1 : head2;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = null;
        ListNode next = null;
        while (cur1!=null && cur2!=null){
            if(cur1.value<=cur2.value){
                pre = cur1;
                cur1 = cur1.next;
            }else{
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
