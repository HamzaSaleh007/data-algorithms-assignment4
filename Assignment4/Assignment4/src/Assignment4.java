import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
/**
* I Hamza Saleh, 0008887384 certify that this material is my original work, I have not copied from anyone nor allowed anyone to copy it.
 * Discussion of performance
 *
 * 1. Performance Difference When Adding Items:
 *    SortedLinkedList took approximately 2.65 seconds to add 18,756 elements, whereas ArrayList with sorting after
 *    each addition, took about 3.76 seconds. This difference arises because, in SortedLinkedList each addition requires
 *    finding the correct position to maintain the order, which has a time complexity of O(n) in the worst case.
 *    ArrayList allows for O(1) time complexity for addition but requires a sort, making each addition effectively O(n log n) due to the sorting step.
 *
 * 2. Performance Difference When Removing Items:
 *    There is a big difference in performance between the two collections when removing items. The SortedLinkedList required about 1.66
 *    seconds to remove half of the elements, significantly longer than the 0.01 seconds taken by ArrayList for the same operation.
 *    This is because removal in SortedLinkedList involves a linear search (O(n)) to find the item, followed by pointer adjustments.
 *    Meanwhile, ArrayList benefits from faster removal due to direct indexing O(1), even though it needs to shift elements after removal,
 *    the overall process is highly optimized in Java, leading to a quick removal operation.
 *
 * 3. Choice Between SortedLinkedList and ArrayList Based on Assignment Results:
 *    Based on the results of this assignment, the choice between using a SortedLinkedList over an ArrayList would depend on the specific requirements
 *    of the operation frequency and data volume. SortedLinkedList is preferable when the application requires maintaining an ordered collection with
 *     infrequent additions and removals, particularly because it ensures order with each insertion without the need for sorting. On the other hand,
 *    ArrayList is favored in scenarios where fast access and removals are critical, especially for large datasets where the impact of sorting after each addition
 *    is mitigated by the faster removal process.
 * */

public class Assignment4 {
  public static void main(String[] args) {
    final int NUMBER_OF_NAMES = 18756;
    final String filename = "src/bnames-1.txt";
    final String[] names = new String[NUMBER_OF_NAMES];
    Random random = new Random(); // May be useful for selecting random words to remove

    // Read in all of the names
    try {
      Scanner fin = new Scanner(new File(filename));
      for (int i = 0; i < NUMBER_OF_NAMES; i++)
        names[i] = fin.next();
      fin.close();
    } catch (FileNotFoundException e) {
      System.out.println("Exception caught: " + e.getMessage());
      System.exit(-1);
    }

    // SortedLinkedList for Strings
    SortedLinkedList<String> linkedList_String = new SortedLinkedList<>();
    // Add all the names to the SortedLinkedList and time the operation
    long start = System.nanoTime();
    for (int i = 0; i < NUMBER_OF_NAMES; i++)
      linkedList_String.add(names[i]);
    long duration = (System.nanoTime() - start) / 1000;
    System.out.printf("Time to add %d elements to SortedLinkedList<String>: %d us\n", NUMBER_OF_NAMES, duration);
    System.out.println("------------------------------------------------------------------------------------------------");
    // Print the top 10 names

    System.out.println("Top 10 names after adding: " + linkedList_String.toString());
    System.out.println("------------------------------------------------------------------------------------------------");


    // Remove Aabha and Aadhira from the list and print the top 10 names
    linkedList_String.remove("Aabha");
    linkedList_String.remove("Aadhira");
    System.out.println("Top 10 names after removing Aabha and Adhira " + linkedList_String.toString());
    System.out.println("------------------------------------------------------------------------------------------------");



    // Remove half the items from SortedLinkedList<String> and time the operation
    start = System.nanoTime();
    for (int i = 0; i < NUMBER_OF_NAMES / 2; i++)
      linkedList_String.remove(names[random.nextInt(NUMBER_OF_NAMES)]);
    duration = (System.nanoTime() - start) / 1000;
    System.out.printf("Time to remove half the elements from SortedLinkedList<String>: %d us\n", duration);
    System.out.println("------------------------------------------------------------------------------------------------");

    // Print the top 10 names after removing half the items
    System.out.println("Top 10 names after removing: " + linkedList_String.toString());
    System.out.println("------------------------------------------------------------------------------------------------");


    // Demonstrate SortedLinkedList with another data type (Integer)
    SortedLinkedList<Integer> linkedList_Integer = new SortedLinkedList<>();
    int x=10;
    for (int i = 0; i < x; i++) {
      linkedList_Integer.add(random.nextInt(100)); // Add 20 random integers
    }
    System.out.println("SortedLinkedList<Integer> contains " + x +" Integers :" + linkedList_Integer.toString());
    System.out.println("------------------------------------------------------------------------------------------------");


    // ArrayList of String with sorting after each addition
    ArrayList<String> arrayList_String = new ArrayList<>();
    start = System.nanoTime();
    for (String name : names) {
      arrayList_String.add(name);
      Collections.sort(arrayList_String); // Sort after each addition
    }
    duration = (System.nanoTime() - start) / 1000;
    System.out.printf("Time to add and sort %d elements in ArrayList<String>: %d us\n", NUMBER_OF_NAMES, duration);
    System.out.println("------------------------------------------------------------------------------------------------");


    // Remove half the items from ArrayList<String> and time the operation
    start = System.nanoTime();
    for (int i = 0; i < NUMBER_OF_NAMES / 2; i++)
      arrayList_String.remove(random.nextInt(arrayList_String.size()));
    duration = (System.nanoTime() - start) / 1000;
    System.out.printf("Time to remove half the elements from ArrayList<String>: %d us\n", duration);
  }
}
