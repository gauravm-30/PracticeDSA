package org.practice.maps;

public class OpenHashingClosedHashing {

  public static void main(String[] args) {
    openAndClosedHashing();
  }

  private static void openAndClosedHashing() {
    /*
        * Certainly! Let's dive into **Open Hashing** (also known as **Separate Chaining**) and **Closed Hashing** (also known as **Open Addressing**), two collision handling techniques used in hash tables. 🌟

    ### Open Hashing (Separate Chaining)
    In **Open Hashing**, collisions are resolved by storing multiple values together in the same index. Here's how it works:

    1. **Chaining with Linked Lists**: In Open Hashing, we use a linked list data structure to handle collisions. When multiple elements hash to the same index, they are inserted into a singly-linked list (referred to as a "chain"). Each index in the hash table contains a chain of elements that collided.

    2. **Searching the Chain**: To find an entry with a specific key, we traverse the chain linearly. If the key matches the intrinsic key for any entry in the linked list, we've found our entry. If we reach the end of the list without finding the desired entry, it means the entry doesn't exist.

    3. **Advantages**:
       - Simple to implement and understand.
       - The hash table can grow dynamically, allowing us to add new elements.
       - Less sensitive to load factors or hash function variations.
       - Suitable when we don't know the frequency of key insertions or deletions.

    4. **Disadvantages**:
       - Cache performance is poor due to singly-linked lists.

    ### Closed Hashing (Open Addressing)
    In **Closed Hashing**, collisions are resolved by storing one of the records at another slot within the table. Here's how it differs:

    1. **Utilizing Empty Indexes**: Closed Hashing aims to use empty indexes in the hash table to handle collisions. When a collision occurs, the algorithm searches for the next available slot (using various probing techniques) to place the conflicting element.

    2. **Probing Techniques**:
       - **Linear Probing**: If an index is occupied, the algorithm checks the next index (linearly) until an empty slot is found.
       - **Quadratic Probing**: The algorithm uses quadratic increments to search for an empty slot.
       - **Double Hashing**: It combines two hash functions to determine the next index to probe.

    3. **Advantages**:
       - Better cache performance due to contiguous memory access.
       - No need for additional data structures (like linked lists).

    4. **Disadvantages**:
       - Requires careful handling of load factors and probing techniques.
       - Can lead to clustering (groups of occupied slots).

    Remember, despite the confusing naming convention, **Open Hashing** stores collisions outside the table, while **Closed Hashing** stores one of the records within the table itself¹²³⁴. Feel free to explore these techniques further based on your Java development interests! 😊🚀

    Source: Conversation with Copilot, 26/5/2024
    (1) Open and Closed Hashing in Java - Javatpoint. https://www.javatpoint.com/open-and-closed-hashing-in-java.
    (2) Open Addressing - a collision handling method in Hash Tables. https://iq.opengenus.org/open-addressing/.
    (3) 10.4. Open Hashing — CS3 Data Structures & Algorithms - Virginia Tech. https://opendsa-server.cs.vt.edu/ODSA/Books/CS3/html/OpenHash.html.
    (4) Open Addressing Collision Handling technique in Hashing. https://www.geeksforgeeks.org/open-addressing-collision-handling-technique-in-hashing/.
    (5) en.wikipedia.org. https://en.wikipedia.org/wiki/Open_addressing.
        * */
  }
}
