
/**
 * Generic Linked List class that always keeps the elements in order 
 * @author mark.yendt
 */
public class SortedLinkedList<T extends Comparable> {
  /**
   * The Node class stores a list element and a reference to the next node.
   */
  private final class Node<T extends Comparable> {
    T value;
    Node next;

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     * @param n   The reference to the successor node.
     */
    Node(T val, Node n) {
      value = val;
      next = n;
    }

    /**
     * Constructor.
     *
     * @param val The element to store in the node.
     */
    Node(T val) {
      // Call the other (sister) constructor.
      this(val, null);
    }
  }

  private Node first;  // list head

  /**
   * Constructor.
   */
  public SortedLinkedList() {
    first = null;
  }

  /**
   * The isEmpty method checks to see if the list is empty.
   *
   * @return true if list is empty, false otherwise.
   */
  public boolean isEmpty() {
    return first == null;
  }

  /**
   * The size method returns the length of the list.
   *
   * @return The number of elements in the list.
   */
  public int size() {
    int count = 0;
    Node p = first;
    while (p != null) {
      // There is an element at p
      count++;
      p = p.next;
    }
    return count;
  }

  /**
   * The add method adds an element at a position.
   *
   * @param element The element to add to the list in sorted order.
   */
  public void add(T element) {
    Node<T> newNode = new Node<>(element);
    if (first == null || first.value.compareTo(element) > 0) {
      newNode.next = first;
      first = newNode;
    } else {
      Node<T> current = first;
      while (current.next != null && current.next.value.compareTo(element) < 0) {
        current = current.next;
      }
      newNode.next = current.next;
      current.next = newNode;
    }
  }


  /**
   * The toString method computes the string representation of the list.
   *
   * @return The string form of the list.
   */
  @Override
  public String toString() {
    StringBuilder listOfItems = new StringBuilder("[");
    Node<T> current = first;
    int count = 0; //  a counter to limit the number of elements printed
    while (current != null && count < 10) { // Only iterate through the first 10 elements or until the list ends
      listOfItems.append(current.value.toString());
      if (current.next != null && count < 9) { // Check if there's a next element and the count is less than 9
        listOfItems.append(", ");
      }
      current = current.next;
      count++;
    }
    if (size() > 10) {
      listOfItems.append(", ..."); // Indicate that there are more elements
    }
    listOfItems.append("]");
    return listOfItems.toString();
  }



  /**
   * The remove method removes an element.
   *
   * @param element The element to remove.
   * @return true if the remove succeeded, false otherwise.
   */
  public boolean remove(T element) {
    if (first == null) return false;

    if (first.value.equals(element)) {
      first = first.next;
      return true;
    }

    Node<T> current = first;
    while (current.next != null && !current.next.value.equals(element)) {
      current = current.next;
    }

    if (current.next == null) return false;

    current.next = current.next.next;
    return true;
  }
}
