package Lab04;

/**
 * Represents a node in the list of integers containing an integer value and a reference to the rest of the list.
 * An element node signifies a non-empty element in the recursive structure of the list.
 */
public class ElementNode implements ListOfInts {

  private final int data;
  private final ListOfInts rest;

  /**
   * Constructs an element node with the given integer data and a reference to the rest of the list.
   *
   * @param data The integer value of the node.
   * @param rest The rest of the list.
   */
  public ElementNode(int data, ListOfInts rest) {
    this.data = data;
    this.rest = rest;
  }

  /**
   * Adds a new integer to the front of the element node, creating a new node.
   *
   * @param data The integer to prepend.
   * @return A new list with the added element.
   */
  @Override
  public ListOfInts prepend(int data) {
    return new ElementNode(data, this);
  }

  /**
   * Adds a new integer to the end of the element node, creating a new node.
   *
   * @param data The integer to append.
   * @return A new list with the added element.
   */
  @Override
  public ListOfInts append(int data) {
    return new ElementNode(this.data, rest.append(data));
  }

  /**
   * Inserts a new integer at the specified index in the element node.
   *
   * @param data  The integer to insert.
   * @param index The index at which to insert the element.
   * @return A new list with the inserted element.
   */
  @Override
  public ListOfInts insertAtIndex(int data, int index) {
    if (index == 0) {
      return new ElementNode(data, this);
    }
    return new ElementNode(this.data, rest.insertAtIndex(data, index - 1));
  }

  /**
   * Retrieves the integer at the specified index in the element node.
   *
   * @param index The index of the element to retrieve.
   * @return The integer at the specified index.
   */
  @Override
  public int getDataAtIndex(int index) {
    if (index == 0) {
      return data;
    }
    return rest.getDataAtIndex(index - 1);
  }

  /**
   * Retrieves the rest of the element node, excluding the first element.
   *
   * @return The rest of the list.
   */
  @Override
  public ListOfInts getRest() {
    return rest;
  }

  /**
   * Gets the length of the element node.
   *
   * @return The length of the element node and its rest.
   */
  @Override
  public int getCount() {
    return 1 + rest.getCount();
  }

  /**
   * Gets the sum of elements in the element node and its rest.
   *
   * @return The sum of elements in the element node and its rest.
   */
  @Override
  public int getSum() {
    return data + rest.getSum();
  }

  /**
   * Returns a string representation of the element node.
   *
   * @return A string representation of the element node and its rest.
   */
  @Override
  public String toString() {
    return "ElementNode{" +
        "data=" + data +
        ", rest=" + rest +
        '}';
  }
}
