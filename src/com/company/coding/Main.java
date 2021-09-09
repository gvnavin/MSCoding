package com.company.coding;

import java.util.ArrayList;

public class Main {

    /**
     * Design and Implement Inorder iterator for Binary Tree
     * Root of the Tree will be give as input
     * <p>
     * Tree
     *      1
     *    2  3
     *  4 5 6 7
     *   8
     * <p>
     * Inorder = 2, 1, 3
     *
     * 1, 2, 4
     * next() -> Stack.pop()
     * 4 -> 1, 2
     * 2 -> 1, 5, 8
     * 8 -> 1, 5
     * 5 -> 1,
     * 1 -> 3, 6
     * 6 -> 3
     * 3 -> 7
     * 7
     *
     *
     *
     * Collection.iterator()
     * <p>
     * hasNext()
     * next() -> reference
     *
     * @param args
     */
    public static void main(String[] args) {
        // write your code here
        System.out.println("args = " + args);
        TreeNode node1 = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
//        TreeNode node1 = new TreeNode(1);
        final TreeNodeIterator treeNodeIterator = new TreeNodeIterator(node1);

        TreeNode temp = null;
        while ((temp = treeNodeIterator.next()) != null) {
            System.out.print(temp.value + ",");
        }
        System.out.println();
    }

    static class TreeNode {
        int value;
        TreeNode leftChild;
        TreeNode rightChild;

        public TreeNode(int i) {
            value = i;
        }
    }

    static class TreeNodeIterator {
        private ArrayList<TreeNode> stack = new ArrayList<>();

        public TreeNodeIterator(TreeNode root) {
            populateStackWithChildrenInLeftBrach(root);
        }

        private void populateStackWithChildrenInLeftBrach(TreeNode root) {

            TreeNode temp = root;       //don't change the function input
            while (temp != null) {      //bug: last - fixed
                stack.add(temp);
                temp = temp.leftChild;
            }
        }

        public TreeNode next() {
            if (stack.isEmpty()) {
                return null;
            }

            TreeNode currentNode = stack.remove(stack.size()-1);  //bug: last element remove

            populateStackWithChildrenInLeftBrach(currentNode.rightChild);   //code simplificiation

            return currentNode;
        }
    }

}


