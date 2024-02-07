package Lab04;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ListOfIntsTest {

  @Test
  void prepend() {
    ListOfInts list = new EmptyNode();
    list = list.prepend(10);
    assertEquals("ElementNode{data=10, rest=EmptyNode}", list.toString());
  }

  @Test
  void append() {
    ListOfInts list = new EmptyNode();
    list = list.append(10);
    assertEquals("ElementNode{data=10, rest=EmptyNode}", list.toString());
  }

  @Test
  void insertAtIndex() {
    ListOfInts list = new EmptyNode();
    list = list.insertAtIndex(10, 0);
    assertEquals("ElementNode{data=10, rest=EmptyNode}", list.toString());
  }

  @Test
  void getDataAtIndex() {
    ListOfInts list = new ElementNode(10, new EmptyNode());
    assertEquals(10, list.getDataAtIndex(0));
  }

  @Test
  void getRest() {
    ListOfInts list = new ElementNode(10, new EmptyNode());
    assertEquals("EmptyNode", list.getRest().toString());
  }

  @Test
  void getCount() {
    ListOfInts list = new ElementNode(10, new ElementNode(20, new EmptyNode()));
    assertEquals(2, list.getCount());
  }

  @Test
  void getSum() {
    ListOfInts list = new ElementNode(10, new ElementNode(20, new EmptyNode()));
    assertEquals(30, list.getSum());
  }

  @Test
  void emptyNodePrepend() {
    ListOfInts list = new EmptyNode();
    list = list.prepend(5);
    assertEquals("ElementNode{data=5, rest=EmptyNode}", list.toString());
  }

  @Test
  void elementNodePrepend() {
    ListOfInts list = new ElementNode(10, new EmptyNode());
    list = list.prepend(5);
    assertEquals("ElementNode{data=5, rest=ElementNode{data=10, rest=EmptyNode}}", list.toString());
  }

  @Test
  void emptyNodeAppend() {
    ListOfInts list = new EmptyNode();
    list = list.append(5);
    assertEquals("ElementNode{data=5, rest=EmptyNode}", list.toString());
  }

  @Test
  void elementNodeAppend() {
    ListOfInts list = new ElementNode(5, new EmptyNode());
    list = list.append(10);
    assertEquals("ElementNode{data=5, rest=ElementNode{data=10, rest=EmptyNode}}", list.toString());
  }

  @Test
  void emptyNodeInsertAtIndex() {
    ListOfInts list = new EmptyNode();
    list = list.insertAtIndex(5, 0);
    assertEquals("ElementNode{data=5, rest=EmptyNode}", list.toString());
  }

  @Test
  void elementNodeInsertAtIndex() {
    ListOfInts list = new ElementNode(5, new EmptyNode());
    list = list.insertAtIndex(10, 0);
    assertEquals("ElementNode{data=10, rest=ElementNode{data=5, rest=EmptyNode}}", list.toString());
  }

  @Test
  void elementNodeInsertAtIndexException() {
    ListOfInts list = new ElementNode(5, new EmptyNode());
    assertThrows(IndexOutOfBoundsException.class, () -> list.insertAtIndex(10, 100));
  }

  @Test
  void emptyNodeGetDataAtIndexException() {
    ListOfInts list = new EmptyNode();
    assertThrows(IndexOutOfBoundsException.class, () -> list.getDataAtIndex(0));
  }

  @Test
  void elementNodeGetDataAtIndex() {
    ListOfInts list = new ElementNode(5, new EmptyNode());
    assertEquals(5, list.getDataAtIndex(0));
  }

  @Test
  void elementNodeGetRest() {
    ListOfInts list = new ElementNode(5, new ElementNode(10, new EmptyNode()));
    assertEquals("ElementNode{data=10, rest=EmptyNode}", list.getRest().toString());
  }

  @Test
  void emptyNodeGetRestException() {
    ListOfInts list = new EmptyNode();
    assertThrows(UnsupportedOperationException.class, list::getRest);
  }

  @Test
  void emptyNodeGetCount() {
    ListOfInts list = new EmptyNode();
    assertEquals(0, list.getCount());
  }

  @Test
  void elementNodeGetCount() {
    ListOfInts list = new ElementNode(5, new ElementNode(10, new EmptyNode()));
    assertEquals(2, list.getCount());
  }

  @Test
  void emptyNodeGetSum() {
    ListOfInts list = new EmptyNode();
    assertEquals(0, list.getSum());
  }

  @Test
  void elementNodeGetSum() {
    ListOfInts list = new ElementNode(5, new ElementNode(10, new EmptyNode()));
    assertEquals(15, list.getSum());
  }

  @Test
  void elementNodeGetDataAtIndexRecursive() {
    ListOfInts list = new ElementNode(5, new ElementNode(10, new EmptyNode()));
    assertEquals(5, list.getDataAtIndex(0));
    assertEquals(10, list.getDataAtIndex(1));
  }
}
