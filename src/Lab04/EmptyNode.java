package Lab04;

/**
 * Represents an empty node in the list of integers.
 * An empty node signifies the end of the list in a recursive structure.
 */
public class EmptyNode implements ListOfInts {

  /**
   * Constructs an empty node.
   */
  public EmptyNode() {
  }

  /**
   * Adds a new integer to the front of the empty list, creating a new node.
   *
   * @param data The integer to prepend.
   * @return A new list with the added element.
   */
  @Override
  public ListOfInts prepend(int data) {
    return new ElementNode(data, this);
  }

  /**
   * Adds a new integer to the end of the empty list, creating a new node.
   *
   * @param data The integer to append.
   * @return A new list with the added element.
   */
  @Override
  public ListOfInts append(int data) {
    return new ElementNode(data, this);
  }

  /**
   * Inserts a new integer at the specified index in the empty list.
   *
   * @param data  The integer to insert.
   * @param index The index at which to insert the element.
   * @return A new list with the inserted element.
   * @throws IndexOutOfBoundsException if the index is not 0.
   */
  @Override
  public ListOfInts insertAtIndex(int data, int index) throws IndexOutOfBoundsException {
    if (index != 0) {
      throw new IndexOutOfBoundsException("Index out of range");
    }
    return new ElementNode(data, this);
  }

  /**
   * Retrieves the integer at the specified index in the empty list.
   *
   * @param index The index of the element to retrieve.
   * @return The integer at the specified index.
   * @throws IndexOutOfBoundsException since the list is empty.
   */
  @Override
  public int getDataAtIndex(int index) throws IndexOutOfBoundsException {
    throw new IndexOutOfBoundsException("Index out of range");
  }

  /**
   * Retrieves the rest of the empty list, which is not possible.
   *
   * @return UnsupportedOperationException since the list is empty.
   */
  @Override
  public ListOfInts getRest() throws UnsupportedOperationException {
    throw new UnsupportedOperationException("Cannot get rest of an empty list");
  }

  /**
   * Gets the length of the empty list.
   *
   * @return The length of the empty list, which is 0.
   */
  @Override
  public int getCount() {
    return 0;
  }

  /**
   * Gets the sum of elements in the empty list.
   *
   * @return The sum of elements in the empty list, which is 0.
   */
  @Override
  public int getSum() {
    return 0;
  }

  /**
   * Returns a string representation of the empty node.
   *
   * @return "EmptyNode" as a string.
   */
  @Override
  public String toString() {
    return "EmptyNode";
  }
}
