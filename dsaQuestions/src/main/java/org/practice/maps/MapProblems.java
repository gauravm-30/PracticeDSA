package org.practice.maps;

/*
* Certainly! Let's explore the differences between **HashMap**, **TreeMap**, and **LinkedHashMap** in Java:

1. **HashMap**:
   - Offers O(1) lookup and insertion time complexity.
   - The ordering of keys is essentially arbitrary when iterating through them.
   - Implemented using an array of linked lists.
   - Contains values based on keys.
   - Allows only unique elements.
   - May have one null key and multiple null values.
   - Maintains no specific order¹.

2. **LinkedHashMap**:
   - Also offers O(1) lookup and insertion time complexity.
   - Orders keys based on their insertion order.
   - Implemented using doubly-linked buckets.
   - Contains values based on keys.
   - Allows only unique elements.
   - May have one null key and multiple null values.
   - Maintains the insertion order¹.

3. **TreeMap**:
   - Offers O(log N) lookup and insertion time complexity.
   - Orders keys, allowing iteration in sorted order.
   - Requires keys to implement the `Comparable` interface.
   - Implemented using a Red-Black Tree.
   - Contains values based on keys.
   - Allows only unique elements.
   - First entry (key, value) can have a null key, but subsequent keys cannot be null.
   - Maintains ascending order¹.

In summary:
- **HashMap** has fast lookups but no specific key order.
- **LinkedHashMap** maintains insertion order.
- **TreeMap** provides sorted keys based on natural order.

Feel free to ask if you need further clarification! 😊

Source: Conversation with Copilot, 26/5/2024
(1) Differences between TreeMap, HashMap and LinkedHashMap in Java. https://www.geeksforgeeks.org/differences-treemap-hashmap-linkedhashmap-java/.
(2) Difference between HashMap, TreeMap, and LinkedHashMap in Java. https://www.techiedelight.com/difference-between-hashmap-treemap-linkedhashmap-java/.
(3) HashMap vs. TreeMap vs. HashTable vs. LinkedHashMap - DZone. https://dzone.com/articles/hashmap-vs-treemap-vs.
(4) Differences between TreeMap, HashMap and LinkedHashMap in Java - BYJU'S. https://byjus.com/gate/difference-between-treemap-hashmap-and-linkedhashmap-in-java/.
(5) java - Difference between HashMap, LinkedHashMap and TreeMap - Stack .... https://stackoverflow.com/questions/2889777/difference-between-hashmap-linkedhashmap-and-treemap.
* */

import java.util.Map;
import java.util.TreeMap;

public class MapProblems {
  // I want key in sorted order in map .Which one I need to use.
  public static void main(String[] args) {

    Map<Integer, Integer> treemap = new TreeMap<>();
    treemap.put(1, 2);
    treemap.put(-1, 2);
    treemap.put(2, 2);

    treemap.entrySet().forEach((entr) -> System.out.println("entry = " + entr.getKey()));
  }
}
