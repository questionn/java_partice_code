package com.structure.huffmantree_pac;

import java.util.*;

public class HuffmanTree {
    //创建赫夫曼树
    public class TreeNode implements Comparable<TreeNode>{    //因为创建赫夫曼树时，需要对接点进行排序
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }


        @Override
        public int compareTo(TreeNode o) {
            return this.val - o.val;    //实现升序
        }
    }

    public TreeNode createHuffmanTree(int[] tree) {

        //1、需要对数列进行排列，使用list集合
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        //数组元素放入list
        for (int value : tree
        ) {
            nodes.add(new TreeNode(value));
        }

        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            //取出最小的两个
            TreeNode leftNode = nodes.get(0);
            TreeNode rightNode = nodes.get(1);
            //生出父节点
            TreeNode parent = new TreeNode(leftNode.val + rightNode.val);
            parent.left = leftNode;
            parent.right = rightNode;
            //删除使用过的两个最小节点（list）
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //添加parent继续进行
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    //前序遍历
    public void preOrderNonR(TreeNode node){
        //非递归写
        Stack<TreeNode> stack = new Stack<TreeNode>();

        TreeNode cur = node;
        TreeNode tmp = null;
        while(cur != null || !stack.empty()) {
            while (cur != null) {
                System.out.print(cur.val + " ");
                stack.push(cur);
                cur = cur.left;
            }
            tmp = stack.pop();
            cur = tmp.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

    }
}
