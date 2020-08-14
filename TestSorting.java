/**
 * @author Jude Gerhart
 * @written 6/23/2020
 * @source code Integer versions from GeeksforGeeks/CourseSite
 * Project3
 * CSE17
 */
import java.util.Arrays;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class TestSorting{
  public static void main (String [] args) throws FileNotFoundException{
      //output to txt file 
    File outputFile = new File("results.txt"); //creates new file object
    PrintWriter writer = new PrintWriter(outputFile); //for writing to file
    writer.println("Sorting \tRandom \tSorted \t25% \t50% \t75% \tInverted ");
    writer.println();
    
      //A copy of the source array is used for each sort 
    
    Integer [] array;  //create array of type Integer
    Integer [] arrayCopy;
           /* --------- Random Array Sorting Tests--------------*/
    array = randomized(); //fill
    arrayCopy = copy(array);
    //iteration count for each algorithm sorting random array
    int selectionRandom = Sort.selectionSort(copy(array));
    int insertionRandom = Sort.insertionSort(copy(array)); 
    int bubbleRandom = Sort.bubbleSort(copy(array));
    int mergeRandom = Sort.mergeSort(copy(array));
    int quickRandom = Sort.quickSort(copy(array));
    int heapRandom = Sort.heapSort(copy(array));
    
    //System.out.println("Iterations: "+mergeRandom);
    
          /* --------- Sorted Array Sorting Tests --------------*/
    array = fullySorted(array); //sort whole array
    
    int selectionSorted = Sort.selectionSort(copy(array));
    int insertionSorted= Sort.insertionSort(copy(array)); 
    int bubbleSorted= Sort.bubbleSort(copy(array));
    int mergeSorted= Sort.mergeSort(copy(array));
    int quickSorted= Sort.quickSort(copy(array));
    int heapSorted= Sort.heapSort(copy(array));
          /* --------- 1/4 Shuffled Array Sorting Tests -------------*/
    fourthShuffled(array); // 1/4 shuffled
    int selectionFourth= Sort.selectionSort(copy(array));
    int insertionFourth= Sort.insertionSort(copy(array)); 
    int bubbleFourth= Sort.bubbleSort(copy(array));
    int mergeFourth= Sort.mergeSort(copy(array));
    int quickFourth= Sort.quickSort(copy(array));
    int heapFourth= Sort.heapSort(copy(array));
          /* --------- 1/2  Shuffled Array Sorting Tests ------------*/
    halfShuffled(array); // 1/2 shuffled
    int selectionHalf= Sort.selectionSort(copy(array));
    int insertionHalf= Sort.insertionSort(copy(array)); 
    int bubbleHalf= Sort.bubbleSort(copy(array));
    int mergeHalf= Sort.mergeSort(copy(array));
    int quickHalf= Sort.quickSort(copy(array));
    int heapHalf= Sort.heapSort(copy(array));
          /* --------- 3/4 Shuffled Array Sorting Tests -------------*/
    threeQuarterShuffled(array); // 3/4 shuffled
    int selectionThree= Sort.selectionSort(copy(array));
    int insertionThree= Sort.insertionSort(copy(array)); 
    int bubbleThree= Sort.bubbleSort(copy(array));
    int mergeThree= Sort.mergeSort(copy(array));
    int quickThree= Sort.quickSort(copy(array));
    int heapThree= Sort.heapSort(copy(array));
          /* --------- Inverted Array Sorting Tests --------------*/
    array = inverted(array);// inverts array and returns new array
    int selectionInvert= Sort.selectionSort(copy(array));
    int insertionInvert= Sort.insertionSort(copy(array)); 
    int bubbleInvert= Sort.bubbleSort(copy(array));
    int mergeInvert= Sort.mergeSort(copy(array));
    int quickInvert= Sort.quickSort(copy(array));
    int heapInvert= Sort.heapSort(copy(array));
    
           /* ------------- Output to txt file -----------------*/
    writer.println("Selection Sort\t"+ selectionRandom+"\t"+selectionSorted+"\t"+selectionFourth+"\t"+selectionHalf+"\t"+selectionThree+"\t"+selectionInvert);
    writer.println("Insertion Sort\t"+ insertionRandom+"\t"+insertionSorted+"\t"+insertionFourth+"\t"+insertionHalf+"\t"+insertionThree+"\t"+insertionInvert);
    writer.println("Bubble Sort\t"+ bubbleRandom+"\t"+bubbleSorted+"\t"+bubbleFourth+"\t"+bubbleHalf+"\t"+bubbleThree+"\t"+bubbleInvert);
    writer.println("Merge Sort\t"+ mergeRandom+"\t"+mergeSorted+"\t"+mergeFourth+"\t"+mergeHalf+"\t"+mergeThree+"\t"+mergeInvert);
    writer.println("Quick Sort\t" + quickRandom+"\t"+quickSorted+"\t"+quickFourth+"\t"+quickHalf+"\t"+quickThree+"\t"+quickInvert);
    writer.println("Heap Sort\t" + heapRandom+"\t"+heapSorted+"\t"+heapFourth+"\t"+heapHalf+"\t"+heapThree+"\t"+heapInvert);
    
    writer.close(); //close writer
    System.out.println("end of code reached");
  } //end of main
  
  
    //part a method
  public static Integer[] randomized(){
    Integer [] array = new Integer [1000]; //create new array
    for(int i=0; i<1000; i++){  // fill array
      array[i]= (int) (Math.random()*1000+1);
    }
    return array; 
  }
    //part b method
  public static Integer[] fullySorted(Integer [] array){
    System.out.println("Array is fully sorted");
    Arrays.sort(array);
    return array;
  }
    //part c method
  public static Integer[] fourthShuffled(Integer[] array){
    System.out.println("One fourth shuffled");
    for(int i=0; i<250; i++){
      array[i] = (int) (Math.random()*250+1);
    }
    return array;
  }
    //part d method
  public static Integer[] halfShuffled(Integer[] array){
    System.out.println("Half shuffled");
    for(int i=0; i<500; i++){
      array[i] = (int) (Math.random()*500+1);
    }
    return array;
  }
    //part e method
  public static Integer[] threeQuarterShuffled(Integer[] array){
    System.out.println("Three fourth shuffled");
    for(int i=0; i<750; i++){
      array[i] = (int) (Math.random()*750+1);
    }
    return array;
  }
    //part f method
  public static Integer[] inverted(Integer[] array){
    System.out.println("Array is inverted");
    Integer [] output = new Integer[1000];
    for(int i=0; i<array.length; i++){
      output[i] = array[1000-i-1];
    }
    return output; 
  }
    //make a copy of array 
  public static Integer[] copy (Integer[] array){
    Integer [] output = new Integer [array.length];
    for(int i = 0; i<array.length; i++){
      output[i] = array[i];
    }
    return output;
  }
    //print to console for error checking 
  public static void printHalf(Integer [] array){
    for(int i=0; i<array.length; i++){
      System.out.print(array[i]+" ");
    }
    System.out.println("Finished Print Job");
  }
}