package com.utku.algoplayground.cli;

import com.utku.algoplayground.algorithms.BinarySearch;
import com.utku.algoplayground.algorithms.MergeSort;
import com.utku.algoplayground.algorithms.QuickSort;
import com.utku.algoplayground.datastructures.BinarySearchTree;
import com.utku.algoplayground.datastructures.DynamicArray;
import com.utku.algoplayground.datastructures.Queue;
import com.utku.algoplayground.datastructures.Stack;

import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Simple CLI demo for the AlgoPlayground project.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            System.out.print("Select option: ");
            String input = scanner.nextLine().trim();
            switch (input) {
                case "1" -> demoDynamicArrayAndSorting();
                case "2" -> demoStackAndQueue();
                case "3" -> demoBinarySearchTree();
                case "4" -> demoBinarySearch();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option, please try again.\n");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("===== AlgoPlayground CLI =====");
        System.out.println("1) Demonstrate DynamicArray and sorting");
        System.out.println("2) Demonstrate Stack and Queue");
        System.out.println("3) Demonstrate Binary Search Tree operations");
        System.out.println("4) Demonstrate Binary Search on a sorted array");
        System.out.println("0) Exit");
    }

    private static void demoDynamicArrayAndSorting() {
        System.out.println("\n--- DynamicArray + MergeSort demo ---");
        DynamicArray<Integer> arr = new DynamicArray<>(4);
        arr.add(7);
        arr.add(2);
        arr.add(9);
        arr.add(1);
        arr.add(5); // triggers resize
        System.out.print("DynamicArray contents: ");
        printDynamicArray(arr);

        Integer[] toSort = new Integer[arr.size()];
        for (int i = 0; i < arr.size(); i++) toSort[i] = arr.get(i);
        System.out.println("Sorting with MergeSort...");
        MergeSort.sort(toSort);
        System.out.println("Sorted: " + Arrays.toString(toSort));
        System.out.println();
    }

    private static void demoStackAndQueue() {
        System.out.println("\n--- Stack + Queue demo ---");
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack pop: " + stack.pop());
        System.out.println("Stack empty? " + stack.isEmpty());

        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30); // full, next enqueue will trigger resize
        queue.enqueue(40);
        System.out.println("Queue peek: " + queue.peek());
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue dequeue: " + queue.dequeue());
        System.out.println("Queue empty? " + queue.isEmpty());
        System.out.println();
    }

    private static void demoBinarySearchTree() {
        System.out.println("\n--- BinarySearchTree demo ---");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        int[] values = {8, 3, 10, 1, 6, 14, 4, 7, 13};
        for (int v : values) bst.insert(v);
        List<Integer> inorder = bst.inOrderTraversal();
        System.out.println("In-order traversal (sorted): " + inorder);
        System.out.println("Contains 7? " + bst.contains(7));
        System.out.println("Contains 100? " + bst.contains(100));
        System.out.println("Removing 3 and 10...");
        bst.remove(3);
        bst.remove(10);
        System.out.println("In-order after removals: " + bst.inOrderTraversal());
        System.out.println();
    }

    private static void demoBinarySearch() {
        System.out.println("\n--- BinarySearch demo ---");
        int[] sortedInts = {1, 3, 5, 7, 9, 11, 13};
        int idx = BinarySearch.binarySearch(sortedInts, 7);
        System.out.println("Index of 7 in " + Arrays.toString(sortedInts) + " = " + idx);
        Integer[] sorted = {1, 2, 3, 4, 5};
        int idx2 = BinarySearch.binarySearch(sorted, 4);
        System.out.println("Index of 4 in " + Arrays.toString(sorted) + " = " + idx2);

        System.out.println("QuickSort demo on [9,4,1,7,3]");
        Integer[] arr = {9, 4, 1, 7, 3};
        QuickSort.sort(arr);
        System.out.println("QuickSorted: " + Arrays.toString(arr));
        System.out.println();
    }

    private static <T> void printDynamicArray(DynamicArray<T> arr) {
        System.out.print("[");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i));
            if (i < arr.size() - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}


