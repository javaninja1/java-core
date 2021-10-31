package com.hello.trees;

import java.util.*;

public class MyTree {


    public static void main(String[] args) {
        MyTree tree = new MyTree();
        Node rootNode = tree.getRoot();

        tree.printTree(rootNode);

        List<List<Integer>> levels = tree.getTreeAsLists(rootNode);
        int numSpaces = levels.size() * 2;
        for (List<Integer> level : levels) {
            System.out.format( "%" + numSpaces +"s", "");
            for( int val : level) {
                System.out.print(val + "   ");
            }
            //level.stream().forEach(System.out::print);
            System.out.println();
            numSpaces = numSpaces -2;
        }

        System.out.println("level for 6:" + tree.getLevel(rootNode, 6));
    }

    // Let us create binary tree shown in above diagram

    /*             1
                /     \
               2       3
             /   \       \
            4     5       6
             \
              9
     */
    private  Node getRoot() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        return root;
    }

    public void MyTree() {
        /**
         *            5
         *        2       4
         *     7    3   1    9
         */
        int arr[][] = {{5, 2}, {2, 7}, {2, 3}, {5, 4}, {4, 1}, {4, 9}};
    }

    public void printTree(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(true) {
            //if node count at current level is empty , exit the loop
            int nodeCount = queue.size();
            if (queue.size() == 0) {
                break;
            }

            //Else dequeue all nodes at current level and print
            //enqueue all nodes for next level
            while ( nodeCount > 0 ) {
                Node node = queue.peek();
                System.out.print(node.value);
                queue.remove();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }
            System.out.println("");

        }
    }


    int getLevel (Node node, int data, int level) {
        if (node == null) {
            return 0;
        }

        if (node.value == data) {
            return level;
        }

        int downLevel = getLevel (node.left,data, level +1);
        if (downLevel != 0) {
           return downLevel;
        }
        downLevel = getLevel (node.right, data, level +1 );
        return downLevel;

    }
    int getLevel(Node root, int data) {
        return getLevel(root, data, 1);
    }


    public  List<List<Integer>> getTreeAsLists(Node root) {

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        List<List<Integer>> levels  = new ArrayList<>();

        while(true) {

            //if node count at current level is empty , exit the loop
            int nodeCount = queue.size();
            if (queue.size() == 0) {
                break;
            }

            List<Integer> level = new ArrayList<>();
            levels.add(level);

            //Else dequeue all nodes at current level and print
            //enqueue all nodes for next level
            while ( nodeCount > 0 ) {
                Node node = queue.peek();
                level.add(node.value);
                queue.remove();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                nodeCount--;
            }

        }

        return levels;

    }

    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int i) {
            this.value = i;
        }
    }
}
