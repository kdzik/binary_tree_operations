package com.kdzik;

public class Main {

    public static void main(String[] args) {
	    Tree tree = new Tree();
	    Node root = tree.newNode(5);
	    root.left = tree.newNode(3);
	    root.right = tree.newNode(7);
	    root.left.left = tree.newNode(2);
	    root.left.right = tree.newNode(5);
	    root.right.right = tree.newNode(0);
	    root.right.left = tree.newNode(1);
	    root.right.right.right = tree.newNode(8);
	    root.right.right.left = tree.newNode(2);
	    root.right.right.right.right = tree.newNode(5);

        tree.performAll(root);
		tree.performAll(root.left);
		tree.performAll(root.right);
		tree.performAll(root.right.right);
    }
}
