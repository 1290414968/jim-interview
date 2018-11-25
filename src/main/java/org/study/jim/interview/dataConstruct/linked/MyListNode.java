package org.study.jim.interview.dataConstruct.linked;

import java.util.List;

/**
 * @Auther: jim
 * @Date: 2018/11/25 13:57
 * @Description:
 */
public class MyListNode {
    /**
     * 头节点的插入
     * @param headNode
     * @param newHead
     */
    static void headInsert(ListNode headNode,ListNode newHead){
        ListNode node = headNode;
        headNode = newHead;
        headNode.next = node;
    }
    static void list(ListNode head){
        while (head!=null){
            System.out.print(head.value+" ");
            head = head.next;
        }
        System.out.println();
    }
    /**
     * 尾节点的插入
     * @param tailNode
     * @param newTail
     */
    static void tailInsert(ListNode tailNode,ListNode newTail){
        ListNode node = tailNode;
        tailNode = newTail;
        node.next = tailNode;
        tailNode.next = null;
    }

    /**
     * 节点的插入
     * @param pre
     * @param newNode
     */
    static void insert(ListNode pre,ListNode newNode){
        ListNode node = pre.next;
        pre.next = newNode;
        newNode.next = node;
    }

    /**
     * 删除节点
     * @param head
     * @param node
     */
    static void delete(ListNode head,ListNode node){
        if(node!=null && node.next!=null) {//不是尾节点
            ListNode p = node.next;
            node.value = p.value;
            node.next = p.next;
            p = null;
        }
        if(node!=null && node.next==null){
            while (head!=null){
                if(head==node){
                    head.next = null;
                    node = null;
                    break;
                }
                head = head.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = null;
        list(node1);
        ListNode node0 = new ListNode(0);
        headInsert(node1,node0);
        list(node0);
        ListNode node4 = new ListNode(4);
        tailInsert(node3,node4);
        list(node0);
        ListNode node5 = new ListNode(5);
        insert(node2,node5);
        list(node0);
        delete(node0,node2);
        list(node0);
    }
}
