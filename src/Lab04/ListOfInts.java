package Lab04;

/**
 * An interface representing a list of integers with common operations.
 */
public interface ListOfInts {

  /**
   * Adds a new integer to the front of the list.
   *
   * @param data The integer to prepend.
   * @return A new list with the added element.
   */
  ListOfInts prepend(int data);

  /**
   * Adds a new integer to the end of the list.
   *
   * @param data The integer to append.
   * @return A new list with the added element.
   */
  ListOfInts append(int data);

  /**
   * Inserts a new integer at the specified index in the list.
   *
   * @param data  The integer to insert.
   * @param index The index at which to insert the element.
   * @return A new list with the inserted element.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  ListOfInts insertAtIndex(int data, int index) throws IndexOutOfBoundsException;

  /**
   * Retrieves the integer at the specified index in the list.
   *
   * @param index The index of the element to retrieve.
   * @return The integer at the specified index.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
  int getDataAtIndex(int index) throws IndexOutOfBoundsException;

  /**
   * Retrieves the rest of the list excluding the first element.
   *
   * @return The rest of the list.
   * @throws UnsupportedOperationException if called on an empty list.
   */
  ListOfInts getRest() throws UnsupportedOperationException;

  /**
   * Gets the length of the list.
   *
   * @return The length of the list.
   */
  int getCount();

  /**
   * Gets the sum of all elements in the list.
   *
   * @return The sum of all elements.
   */
  int getSum();
}
