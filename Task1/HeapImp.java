
//java bioler plate
import java.util.*;
import java.io.*;
import java.lang.*;

// The heap must satisfy the heap property.
// Every parent node in the heap must have 2^x children.
// The value of x must be a parameter of the heap’s constructor.
// The heap must implement an insert method.
// The heap must implement a pop max method.
// The heap must be implemented in Java.
// The heap must be performant.
// You must use a more descriptive variable name than x in your implementation.

class Heap {

  public Heap(ArrayList<Integer> arr, int size) {
  }

  void insert(ArrayList<Integer> ht, int newNum) {
    int size = ht.size();

    if (size == 0) {
      ht.add(newNum);
    } else {
      ht.add(newNum);
      for (int i = size / 2 - 1; i >= 0; i--) {
        heapify(ht, i);
      }
    }

  }

  void heapify(ArrayList<Integer> ht, int i) {
    int size = ht.size();
    int largest = i;
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    if (left < size && ht.get(left) > ht.get(largest)) {
      largest = left;
    }
    if (right < size && ht.get(right) > ht.get(largest)) {
      largest = right;
    }

    if (largest != i) {
      int swap = ht.get(largest);
      ht.set(largest, ht.get(i));
      ht.set(i, swap);

      heapify(ht, largest);
    }

  }

  int popMax(ArrayList<Integer> ht) {
    int size = ht.size();
    int max = ht.get(0);
    ht.set(0, ht.get(size - 1));
    ht.remove(size - 1);
    heapify(ht, 0);
    return max;
  }

  void printHeap(ArrayList<Integer> ht) {
    for (Integer i : ht) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

}

public class HeapImp {
  public static void main(String[] args) {

    ArrayList<Integer> arr = new ArrayList<Integer>();
    int size = arr.size();

    Heap heap = new Heap(arr, size);
    heap.insert(arr, 3);
    heap.insert(arr, 4);
    heap.insert(arr, 9);
    heap.insert(arr, 5);

    System.out.println("Max-Heap array: ");
    heap.printHeap(arr);

    System.out.println("Popping max value: " + heap.popMax(arr));
    System.out.println("After popping out");
    heap.printHeap(arr);
  }
}