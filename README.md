# Data Algorithms Assignment 4

## Description
This project implements and compares the performance of a custom `SortedLinkedList` class with Java's built-in `ArrayList`. The `SortedLinkedList` ensures that elements are always sorted as they are added, without using any explicit sorting algorithm. The comparison focuses on the time complexity of adding and removing elements from both data structures.

## Features
- Implementation of `SortedLinkedList<T>` with:
  - **add(T element)**: Adds an element while maintaining sorted order.
  - **remove(T element)**: Removes an element while maintaining sorted order.
  - **toString()**: Prints the elements in sorted order.
- Performance comparison with `ArrayList<T>`:
  - Measures and prints the time taken to add and remove elements.
  - Ensures equivalent functionality by sorting the `ArrayList` after each addition.

## Assignment Requirements
1. **SortedLinkedList Class**:
   - Generic class that supports any data type implementing `Comparable`.
   - Always maintains the sorted state of elements.
2. **Testing**:
   - Demonstrate functionality with two different data types (e.g., `String` and `Integer`).
   - Use a text file (e.g., baby names) as input for testing with strings.
3. **Performance Analysis**:
   - Compare `SortedLinkedList` with `ArrayList` for adding and removing elements.
   - Discuss performance differences using Big O notation.

## File Structure
- `src/`:
  - `SortedLinkedList.java`: Implementation of the generic sorted linked list.
  - `Main.java`: Contains the main method for testing and performance analysis.
  - `input.txt`: Sample input file with names for testing.
- `README.md`: Documentation for the project.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/data-algorithms-assignment4.git
   
2. Open the project in IntelliJ IDEA:
Launch IntelliJ IDEA. Click File > Open and select the project folder.
Run the project:
3. Build and run Main.java to execute the tests and performance comparisons.
