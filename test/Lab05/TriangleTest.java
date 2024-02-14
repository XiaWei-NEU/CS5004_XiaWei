package Lab05;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the Triangle class.
 */
public class TriangleTest {

  private Triangle triangle;

  /**
   * Setup method to initialize the Triangle instance for testing.
   */
  @Before
  public void setup() {
    // Initialize an instance of Triangle for testing
    triangle = new Triangle(0, 0, 0, 3, 4, 0);
  }

  /**
   * Tests whether the Triangle instance has been created with the correct points.
   * It does this by using the toString method.
   */
  @Test
  public void testObjectData() {
    assertEquals("Triangle: points (0.000,0.000), (0.000,3.000), (4.000,0.000)", triangle.toString());
  }

  /**
   * Tests whether the area method works correctly for the Triangle.
   */
  @Test
  public void testArea() {
    // Area of the triangle with vertices (0,0), (0,3), (4,0) is 6 square units
    assertEquals(6, triangle.area(), 0);
  }

  /**
   * Tests whether the perimeter method works correctly for the Triangle.
   */
  @Test
  public void testPerimeter() {
    // Perimeter of the triangle with vertices (0,0), (0,3), (4,0) is 3 + 4 + 5 = 12 units
    assertEquals(12, triangle.perimeter(), 0);
  }

  /**
   * Tests the resize functionality for the Triangle shape.
   */
  @Test
  public void testResize() {
    Shape resizedTriangle = triangle.resize(2);
    assertEquals(1 * triangle.area(), resizedTriangle.area(), 0);
  }
}
