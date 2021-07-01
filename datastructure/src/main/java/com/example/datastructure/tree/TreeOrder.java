package com.example.datastructure.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 树的 前序 中序 后序遍历
 */
public class TreeOrder {
    public List<Integer> list = new ArrayList<>();


    public static void main(String[] args) {

    }


    // 1.前序遍历
    public void preOrder(TreeNode root) {
        if (root != null) {
            list.add(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 2中序遍历
    public void inOrder1(TreeNode root) {
        if (root != null) {
            inOrder1(root.left);
            list.add(root.val);
            inOrder1(root.right);
        }
    }

    // 1.后序遍历
    public void backOrder(TreeNode root) {
        if (root != null) {
            preOrder(root.left);
            preOrder(root.right);
            list.add(root.val);
        }
    }

    //非递归实现
    public void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            if (root != null) {//没有左系节点了
                list.add(root.val);
                stack.push(root);//保存这个根节点
                root = root.left;//去找左节点
            } else {// 从栈中取出该根节点的右节点
                root = stack.pop().right;
            }
        }
    }

    // 2中序遍历
//    public void inOrder2(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        Stack<TreeNode> stack1 = new Stack<>();
//        stack.push(root);
//
//        while (!stack.empty()) {
//
//            root = stack.pop();
//            stack1.push(root);
//
//            if (root.left != null) {
//                stack.push(root.left);
//            }
//
//        }
//
//    }

    // 1.后序遍历
//    public void backOrder2(TreeNode root) {
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.empty()) {
//            if (root != null) {
//                stack.push(root);
//                root = root.left;
//            } else {
//                TreeNode temp = stack.pop();
//                list.add(temp.val);
//            }
//        }
//    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
