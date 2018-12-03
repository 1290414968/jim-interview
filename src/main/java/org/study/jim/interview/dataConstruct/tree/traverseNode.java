package org.study.jim.interview.dataConstruct.tree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Auther: jim
 * @Date: 2018/12/3 08:10
 * @Description:
 */
public class traverseNode {
    //前序
    private static void preOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> treeStack = new Stack<TreeNode>();
            treeStack.push(head);
            while (!treeStack.isEmpty()){
                TreeNode pop =  treeStack.pop();
                System.out.print(pop.value +" ");
                if(pop.right!=null){
                    treeStack.push(pop.right);//先压入右侧值，后弹出右侧值
                }
                if(pop.left!=null){
                    treeStack.push(pop.left);//后压入左侧值，后弹出左侧值
                }
            }
        }
    }
    //中序
    private static void inOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack = new Stack<>();
            while (!stack.isEmpty() || head!=null){
                if(head!=null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }
        }
    }
    //后序
    private static void postOrder(TreeNode head){
        if(head!=null){
            Stack<TreeNode> stack1 = new Stack<>();
            Stack<TreeNode> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()){
                TreeNode pop = stack1.pop();
                stack2.push(pop);
                if(pop.left!=null){
                    stack1.push(pop.left);
                }
                if(pop.right!=null){
                    stack1.push(pop.right);
                }
            }
            while (!stack2.isEmpty()){
                System.out.print(stack2.pop().value + " ");
            }
        }
    }
    //层次
    private static void levelOrder(TreeNode head){
        if(head!=null){
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.offer(head);
            while (!queue.isEmpty()){
                int levelNum = queue.size();
                for(int i=0;i<levelNum;i++){
                    TreeNode poll = queue.poll();
                    System.out.print(poll.value +" ");
                    if(poll.left!=null){
                        queue.offer(poll.left);
                    }
                    if(poll.right!=null){
                        queue.offer(poll.right);
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode("A");
        TreeNode b = new TreeNode("B");
        TreeNode c = new TreeNode("C");
        TreeNode d = new TreeNode("D");
        TreeNode e = new TreeNode("E");
        TreeNode f = new TreeNode("F");
        TreeNode g = new TreeNode("G");
        TreeNode h = new TreeNode("H");
        TreeNode i = new TreeNode("I");
        TreeNode j = new TreeNode("J");
        TreeNode k = new TreeNode("K");
        a.left = b;
        a.right = c;
        b.left =  d;
        b.right = e;
        d.left = h;
        d.right = i;
        e.right = j;
        c.left = f;
        c.right = g;
        f.right = k;
        preOrder(a);
        System.out.println();
        inOrder(a);
        System.out.println();
        postOrder(a);
        System.out.println();
        levelOrder(a);
    }
}
