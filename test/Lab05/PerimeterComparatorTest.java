package Lab05;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * JUnit tests for the PerimeterComparator class.
 */
public class PerimeterComparatorTest {

  private PerimeterComparator perimeterComparator;
  private Shape circle, rectangle, triangle;

  /**
   * Setup method to initialize the PerimeterComparator and shapes for testing.
   */
  @Before
  public void setup() {
    perimeterComparator = new PerimeterComparator();
    // Initialize instances of shapes for testing
    circle = new Circle(3, 4, 5);
    rectangle = new Rectangle(2, 3, 4, 5);
    triangle = new Triangle(0, 0, 0, 3, 4, 0);
  }

  /**
   * Tests the compare method of PerimeterComparator.
   * The expected results are based on the calculated perimeters of the shapes.
   */
  @Test
  public void testCompare() {
    // Circumference of circle: 2 * π * radius = 2 * π * 5
    // Perimeter of rectangle: 2 * (width + height) = 2 * (4 + 5)
    // Perimeter of equilateral triangle: 3 * side length = 3 * (4 + 3 + 5)
    // Therefore, the circle has the smallest perimeter, followed by the rectangle, and then the triangle.
    assertEquals(-1, perimeterComparator.compare(circle, rectangle));
    assertEquals(-1, perimeterComparator.compare(rectangle, triangle));
    assertEquals(1, perimeterComparator.compare(triangle, circle));
    assertEquals(0, perimeterComparator.compare(circle, circle));
  }
}
