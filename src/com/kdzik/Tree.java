package com.kdzik;

import java.util.ArrayList;
import java.util.Collections;

public class Tree {
    Node newNode(int key){
        Node temp = new Node(key);
        temp.left = temp.right = null;
        return temp;
    }

    int sumNode(Node root)
    {
        if (root == null)
            return 0;
        return (root.value + sumNode(root.left) +
                sumNode(root.right));
    }

    int findLeftElement(Node root){
        if (root == null)
            return 0;
        return root.left.value;
    }
    int findRightElement(Node root){
        if (root == null)
            return 0;
        return root.right.value;
    }

    ArrayList<Integer> findElements(Node root){
        ArrayList<Integer> elems = new ArrayList<>();
        elems.add(root.value);
        if(root == null)
            return null;
        if(root.left != null)
            elems.addAll(findElements(root.left));
        if(root.right != null)
            elems.addAll(findElements(root.right));
        return elems;
    }


    int countNodes(Node root){
        int count = 1;
        if (root == null)
            return 0;
        else{
            count += countNodes(root.left);
            count += countNodes(root.right);
            return count;
        }
    }

    double calculateMediumVal(Node root){
        int sum = sumNode(root);
        int numOfElems = countNodes(root);
        System.out.println(sum + " / " + numOfElems);
        double mediumVal = (double)sum/numOfElems;
        return Math.round(mediumVal * 100.0) / 100.0;
    }

    double calculateMedianVal(Node root){
        ArrayList<Integer> elems = findElements(root);
        Collections.sort(elems);
        double median = 0;
        int listSize = elems.size();
        if(elems.size() % 2 == 0){
            median = (double)(elems.get(listSize/2 - 1) + elems.get(listSize/2))/2;
        } else {
            median = elems.get(listSize/2);
        }
        return Math.round(median * 100.0) / 100.0;
    }

    void performAll(Node root){
        System.out.println("=========SELECTED TREE STRUCTURE=========");
        BTreePrinter.printNode(root);
        System.out.println("=================RESULTS=================");
        System.out.println("Sum of nodes: " + sumNode(root));
        System.out.println("Medium value: " + calculateMediumVal(root));
        System.out.println("Median value: " + calculateMedianVal(root));
        System.out.println("\n");
    }
}
