/**
 * @author Jude Gerhart
 * @written 6/23/2020
 * @source code int versions from GeeksforGeeks/CourseSite
 * CSE17  project3  Prof Carr
 */
import java.util.*;
import java.util.ArrayList;
import java.util.Collections;
public class Sort{
  
 // <E extends Comparable <E>>
  
   /* ----------- 1 -----Selection Sort--------------*/
 // sourced from Coursesite 
  
/*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic selectionSort algorithm
 */
  public static <E extends Comparable <? super E>> int selectionSort( E[] array){ 
  // System.out.println(Arrays.toString(list));
  // Initialize counter for iterations
  int iterations = 0;

  for (int i = 0; i < array.length - 1; i++) {
   // Step One: Find the minimum in the list[i..list.length-1]
   //E currentMin = array[i]; 
   int currentMinIndex = i;
   iterations++;
   
   for (int j = i + 1; j < array.length; j++) { 
     if( (array[currentMinIndex].compareTo(array[j]) )>0){
     //currentMin = array[j];
     currentMinIndex = j;
    }
    iterations++; 
   }

   // Step Two: Swap list[i] with the minimum you found above, if necessary
   if (currentMinIndex != i) { 
    E temp = array[currentMinIndex];
    array[currentMinIndex] = array[i]; 
    array[i] = temp;
    // System.out.println(Arrays.toString(list));
   }

  }
  return iterations;
 }
  
   /* ---------- 2 -----Insertion Sort--------------*/
 //source from coursesite
 /*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic insertion sort algorithm
 */
 public static <E extends Comparable <E>> int insertionSort(E[] list) { 
 // System.out.println(Arrays.toString(list));
  //Initialize counter for iterations
  int iterations = 0;
  //For element list[i] in the array.....
  for (int i = 1; i < list.length; i++) {
   // Insert list[i] into a sorted sublist list[0..i-1] \
   // so that list[0..i] is sorted. 
   iterations++;
   E temp;
   for(int j = i ; j > 0 ; j--){
     if(list[j].compareTo(list[j-1])<0){
     temp = list[j];
     list[j] = list[j-1];
     list[j-1] = temp;
     iterations++;
    }
    else {
     break;
    }    
   }

  // System.out.println(Arrays.toString(list));

  }
  return iterations;
 }
 
 /* ---------- 3 ------Bubble Sort--------------*/
             /* source from course site */
 /*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic bubble sort algorithm
 */
 public static <E extends Comparable <E>> int bubbleSort(E[] list) { 
    int iterations = 0;
    boolean needNextPass = true; 
    for (int k=1; k < list.length && needNextPass; k++) { 
      needNextPass = false;  // pass not needed until a swap 
      // last k-1 elements are already sorted 
     
      for (int i=0; i < list.length - k; i++) { 
        if(list[i].compareTo(list[i+1])>0){
          // swap them 
          E temp = list[i]; 
          list[i] = list[i+1]; 
          list[i+1] = temp; 
          needNextPass = true; 
        } 

        iterations++;
      } 
   //   System.out.println(java.util.Arrays.toString(list)); 
    }
    return iterations;
  }
 
 /* ---------- 4 ------Merge Sort--------------*/
           /* source from course site */ 
 /*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic bubble sort algorithm
 */
    static int iterationsM=0;
   public static <E extends Comparable <E>> int mergeSort(E[] list) { 
     if (list.length > 1) { 
      iterationsM++;
      // BASE CASE: Merge two sorted arrays of 
      //            length n/2
      
      // merge sort the first half 
      E[] firstHalf = (E[]) new Comparable[list.length / 2]; 
      System.arraycopy(list, 0, firstHalf, 0, list.length/2); 
      mergeSort(firstHalf); 
      
      // merge sort the second half 
      int secondHalfLength = list.length - list.length / 2;  
      E[] secondHalf = (E[]) new Comparable [secondHalfLength];
      System.arraycopy(list, list.length/2,  
                       secondHalf, 0, secondHalfLength); 
      mergeSort(secondHalf); 
      
      // merge two halves 
      merge(firstHalf, secondHalf, list); 
    } 
      return iterationsM;
  } 
  
  // Q: Is the merge method recursive?
  private static <E extends Comparable <E>> void merge(E[] list1, E[] list2, E[] temp) { 
    iterationsM++;
  //  System.out.println(java.util.Arrays.toString(list1));
  //  System.out.println(java.util.Arrays.toString(list2));
    // temp will store the merged list 
    // Q: Why don't we have to return temp?
    int current1 = 0;   // index in list1 
    int current2 = 0;   // index in list2 
    int current3 = 0;   // index in temp 
    while (current1 < list1.length && current2 < list2.length) { 
      if (list1[current1].compareTo(list2[current2])<0)
        temp[current3++] = list1[current1++]; 
      else 
        temp[current3++] = list2[current2++]; 
    } 
    while (current1 < list1.length) 
      temp[current3++] = list1[current1++]; 
    while (current2 < list2.length) 
      temp[current3++] = list2[current2++]; 
 //   System.out.println(java.util.Arrays.toString(temp));
  }
  
   /* --------- 5 -------Quick Sort--------------*/
              /* source code from coursite */
  /*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic quick sort algorithm
 */
  static int iterationsQ = 0;
   public static  <E extends Comparable <E>> int quickSort(E[] list) { 
    quickSort(list, 0, list.length - 1); 
    return iterationsQ;
  } 
  /** Quick sort a sublist starting from first and ending with last */ 
  private static  <E extends Comparable <E>> void quickSort(E[] list, int first, int last) { 
    if(last>first){
      iterationsQ++;//counter 
      int pivotIndex = partition(list, first, last); 
      quickSort(list, first, pivotIndex - 1); 
      quickSort(list, pivotIndex + 1, last); 
    } 
  } 
  private static <E extends Comparable <E>> int partition(E[] list, int first, int last) { 
    E pivot = list[first]; 
    int low = first + 1; 
    int high = last; 
    while (high > low) { 
      // look for leftmost element > pivot 
      // the <= pivot below is need if there are dupes in list 
      while (low <= high && list[low].compareTo(pivot)<= 0) 
        low++; 
      // look for rightmost element <= pivot 
      while (low <= high && list[high].compareTo(pivot) > 0) 
        high--; 
      if (high > low) {                        // then swap 
        E temp = list[high]; 
        list[high] = list[low]; 
        list[low] = temp; 
      } 
    } 
    // find where pivot needs to be placed 
    while (high > first && list[high].compareTo(pivot)>0)
      high--; 
    // swap pivot with list[high] 
    if (pivot.compareTo(list[high])>0) { 
      list[first] = list[high]; 
      list[high] = pivot; 
      return high; 
    } 
    else 
      return first; 
  }
  
  /* ----------------Heap Sort--------------*/
    /* source @ geeksforgeeks*/
  
 /*
 * @return int iterations
 * @param Comparable array
 * This method implements a generic Heap sort algorithm
 */
   public static <E extends Comparable <E>> int heapSort(E arr[]) 
 { 
  int n = arr.length; 

  // Build heap (rearrange array) 
  for (int i = n / 2 - 1; i >= 0; i--) 
   heapify(arr, n, i); 

  // One by one extract an element from heap 
  for (int i=n-1; i>0; i--) 
  { 
   // Move current root to end 
   E temp = arr[0]; 
   arr[0] = arr[i]; 
   arr[i] = temp; 

   // call max heapify on the reduced heap 
   heapify(arr, i, 0); 
  } 
  return Heap.getIterationsH();
 } 

 // To heapify a subtree rooted with node i which is 
 // an index in arr[]. n is size of heap 
 static <E extends Comparable <E>> void heapify(E arr[], int n, int i) 
 { 
  int largest = i; // Initialize largest as root 
  int l = 2*i + 1; // left = 2*i + 1 
  int r = 2*i + 2; // right = 2*i + 2 

  // If left child is larger than root 
  if (l < n && arr[l].compareTo(arr[largest])>0) 
   largest = l; 

  // If right child is larger than largest so far 
  if (r < n &&  arr[r].compareTo(arr[largest])>0) 
   largest = r; 

  // If largest is not root 
  if (largest != i) 
  { 
   E swap = arr[i]; 
   arr[i] = arr[largest]; 
   arr[largest] = swap; 

   // Recursively heapify the affected sub-tree 
   heapify(arr, n, largest); 
  } 
 } 
 
}//end of sorting class 
 


       /*---------Heap class--------*/
/*int format source code from geeksforgeeks*/
class Heap <E extends Comparable <E>> { 
 private E[] Heap; 
 private int size; 
 private int maxsize; 
 public static int iterationsH;
 // Constructor to initialize an 
 // empty max heap with given maximum 
 // capacity. 
 public void Heap(int maxsize) 
 { 
  this.maxsize = maxsize; 
  this.size = 0; 
  Heap = (E[]) new Comparable [this.maxsize + 1]; 
  //Heap[0] = Integer.MAX_VALUE; 
 } 

 // Returns position of parent 
 private int parent(int pos) 
 { 
  return pos / 2; 
 } 

 // Below two functions return left and 
 // right children. 
 private int leftChild(int pos) 
 { 
  return (2 * pos); 
 } 
 private int rightChild(int pos) 
 { 
  return (2 * pos) + 1; 
 } 

 // Returns true of given node is leaf 
 private boolean isLeaf(int pos) 
 { 
  if (pos >= (size / 2) && pos <= size) { 
   return true; 
  } 
  return false; 
 } 

 private void swap(int fpos, int spos) 
 { 
  E tmp; 
  tmp = Heap[fpos]; 
  Heap[fpos] = Heap[spos]; 
  Heap[spos] = tmp; 
 } 

 // A recursive function to max heapify the given 
 // subtree. This function assumes that the left and 
 // right subtrees are already heapified, we only need 
 // to fix the root. 
 private void maxHeapify(int pos) 
 { 
  if (isLeaf(pos)) 
   return; 
  
  if( (Heap[pos].compareTo(Heap[leftChild(pos)]) <0) || 
   (Heap[pos].compareTo(Heap[rightChild(pos)]) <0) ) { 

   if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) >0) { 
    swap(pos, leftChild(pos)); 
    maxHeapify(leftChild(pos)); 
   } 
   else { 
    swap(pos, rightChild(pos)); 
    maxHeapify(rightChild(pos)); 
   } 
  } 
 } 

 // Inserts a new element to max heap 
 public void insert(E element) 
 { 
   //iterationsH++;
  Heap[++size] = element; 

  // Traverse up and fix violated property 
  int current = size; 
  while (Heap[current].compareTo(Heap[parent(current)]) >0) { 
   swap(current, parent(current)); 
   current = parent(current); 
   iterationsH++;
  }
 } 


 public void print() 
 { 
  for (int i = 1; i <= size / 2; i++) { 
   System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
     Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
   System.out.println(); 
  } 
 } 
 

 // Remove an element from max heap 
 public E extractMax() 
 { 
   iterationsH++;
  E popped = Heap[1]; 
  Heap[1] = Heap[size--]; 
  maxHeapify(1); 
  return popped; 
 } 
 public static int getIterationsH(){
   return iterationsH;
 }
}

