# AlgoPlayground

A Java playground for core data structures and algorithms, featuring from-scratch implementations, unit tests, and a simple CLI demo.

AlgoPlayground is a small but solid Java 17 project that implements fundamental data structures and algorithms from scratch (**no Java Collections for core logic**). It is designed to strengthen CS fundamentals and demonstrate clean Java design, testing discipline, and complexity awareness.

---

## 🛠 Tech

- Java 17  
- Maven (JUnit 5, Exec plugin)

---

## 📁 Project Structure

```text
src/
  main/
    java/
      com/utku/algoplayground/
        cli/Main.java
        datastructures/
          DynamicArray.java
          SinglyLinkedList.java
          Stack.java
          Queue.java
          BinarySearchTree.java
        algorithms/
          BinarySearch.java
          MergeSort.java
          QuickSort.java
  test/
    java/
      com/utku/algoplayground/
        datastructures/
          DynamicArrayTest.java
          StackQueueTest.java
          BinarySearchTreeTest.java
        algorithms/
          AlgorithmsTest.java
✅ Implemented Data Structures
DynamicArray<T>

SinglyLinkedList<T>

Stack<T> (backed by DynamicArray)

Queue<T> (circular array with resize)

BinarySearchTree<T extends Comparable<T>>

✅ Implemented Algorithms
Binary Search (int[] and generic T extends Comparable<T>)

Merge Sort (generic)

Quick Sort (generic)

🚀 Quick Start
bash
Copy code
mvn -q clean package
mvn -q test
mvn -q exec:java -Dexec.mainClass=com.utku.algoplayground.cli.Main
🧪 CLI Demo Menu
Demonstrate DynamicArray and sorting

Demonstrate Stack and Queue

Demonstrate Binary Search Tree operations

Demonstrate Binary Search on a sorted array

Exit

📌 Complexity Summary
Structure/Algorithm	Operation	Time Complexity
DynamicArray	get	O(1)
add (amortized)	O(1)
removeAt	O(n)
SinglyLinkedList	addFirst	O(1)
addLast	O(1)
get(index)	O(n)
removeFirst	O(1)
Stack	push	O(1) amortized
pop/peek	O(1)
Queue (circular array)	enqueue	O(1) amortized
dequeue/peek	O(1)
BinarySearchTree (unbalanced)	insert	O(h) (avg O(log n), worst O(n))
search	O(h) (avg O(log n), worst O(n))
in-order traversal	O(n)
Merge Sort	sort	O(n log n) time, O(n) space
Quick Sort	sort	avg O(n log n), worst O(n^2), O(log n) space (stack)
Binary Search	search	O(log n)

📝 Notes
Duplicates in BST are ignored on insertion (documented in Javadocs).

Public classes and methods contain Javadoc describing behavior and complexities.

makefile
Copy code
::contentReference[oaicite:0]{index=0}
