package com.kdzik;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class TreeTest {
    private Tree tree;

    @org.junit.jupiter.api.BeforeEach
    void setup(){
        tree = new Tree();
    }

    @org.junit.jupiter.api.Test
    void newNode_amount() {
        Node created = tree.newNode(5);
        int treeNodes = tree.countNodes(created);
        int valueOfNode = tree.sumNode(created);
        assertEquals(1, treeNodes, "Wrong amount of nodes");
    }

    @org.junit.jupiter.api.Test
    void newNode_value() {
        Node created = tree.newNode(5);
        int treeNodes = tree.countNodes(created);
        int valueOfNode = tree.sumNode(created);
        assertEquals(5, valueOfNode, "Wrong value of node");
    }

    @org.junit.jupiter.api.Test
    void sumNode() {
        Node root = tree.newNode(5);
        root.left = tree.newNode(3);
        root.right = tree.newNode(7);
        root.right.right = tree.newNode(0);
        root.right.left = tree.newNode(1);
        int sum = tree.sumNode(root);
        assertEquals(16, sum, "Wrong sum of elements");
    }

    @org.junit.jupiter.api.Test
    void findLeftElement() {
        Node root = tree.newNode(3);
        root.left = tree.newNode(2);
        root.right = tree.newNode(1);
        int left = tree.findLeftElement(root);
        assertEquals(2, left);
    }

    @org.junit.jupiter.api.Test
    void findRightElement() {
        Node root = tree.newNode(3);
        root.left = tree.newNode(2);
        root.right = tree.newNode(1);
        int right = tree.findRightElement(root);
        assertEquals(1, right);
    }

    @org.junit.jupiter.api.Test
    void findElements() {
        Node root = tree.newNode(3);
        root.left = tree.newNode(2);
        root.right = tree.newNode(1);
        root.right.right = tree.newNode(5);
        ArrayList<Integer> elems = new ArrayList<>();
        elems.add(3);
        elems.add(2);
        elems.add(1);
        elems.add(5);
        ArrayList<Integer> nodesValues = new ArrayList<>();
        nodesValues = tree.findElements(root);
        assertEquals(elems, nodesValues, "Wrong amount of nodes values");
    }

    @org.junit.jupiter.api.Test
    void countNodes() {
        Node root = tree.newNode(4);
        root.left = tree.newNode(5);
        root.right = tree.newNode(6);
        root.right.right = tree.newNode(3);
        root.right.left = tree.newNode(7);
        int amountOfNodes = tree.countNodes(root);
        assertEquals(5, amountOfNodes, "Wrong amount of nodes");
    }

    @org.junit.jupiter.api.Test
    void calculateMediumVal() {
        Node root = tree.newNode(3);
        root.left = tree.newNode(5);
        root.right = tree.newNode(6);
        root.right.right = tree.newNode(4);
        root.right.left = tree.newNode(7);
        root.right.right.right = tree.newNode(8);
        double medium = tree.calculateMediumVal(root);
        assertEquals(5.5, medium, "Wrong medium value");
    }

    @org.junit.jupiter.api.Test
    void calculateMedianVal() {
        Node root = tree.newNode(4);
        root.left = tree.newNode(5);
        root.right = tree.newNode(6);
        root.right.right = tree.newNode(3);
        root.right.left = tree.newNode(7);
        root.right.right.right = tree.newNode(8);
        double median = tree.calculateMedianVal(root);
        assertEquals(5.5, median, "Wrong median");
    }
}