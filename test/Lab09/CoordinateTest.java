package Lab09;

import static org.junit.Assert.*;
import org.junit.Test;

public class CoordinateTest {
  @Test
  public void test_same_x_and_y_values() {
    Coordinate c1 = new Coordinate(1, 2);
    Coordinate c2 = new Coordinate(1, 2);
    assertTrue(c1.equals(c2));
  }

  @Test
  public void test_different_data_types() {
    Coordinate c1 = new Coordinate(1, 2);
    String c2 = "1,2";
    assertFalse(c1.equals(c2));
  }

  @Test
  public void test_same_hashcode_for_same_x_and_y_values() {
    Coordinate coordinate1 = new Coordinate(1, 2);
    Coordinate coordinate2 = new Coordinate(1, 2);

    int hashCode1 = coordinate1.hashCode();
    int hashCode2 = coordinate2.hashCode();

    assertEquals(hashCode1, hashCode2);
  }

  @Test
  public void test_different_hashcode_for_different_x_values() {
    Coordinate coordinate1 = new Coordinate(1, 2);
    Coordinate coordinate2 = new Coordinate(3, 2);

    int hashCode1 = coordinate1.hashCode();
    int hashCode2 = coordinate2.hashCode();

    assertNotEquals(hashCode1, hashCode2);
  }


}