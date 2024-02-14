package Lab05;

import java.util.Comparator;

/**
 * A comparator for comparing shapes based on their perimeters.
 * Implements the Comparator interface for Shape objects.
 */
public class PerimeterComparator implements Comparator<Shape> {

  /**
   * Compares two shapes based on their perimeters.
   *
   * @param shape1 The first shape to be compared.
   * @param shape2 The second shape to be compared.
   * @return -1 if the perimeter of shape1 is less than shape2,
   *         1 if the perimeter of shape1 is greater than shape2,
   *         0 if the perimeters are equal.
   */
  @Override
  public int compare(Shape shape1, Shape shape2) {
    double perimeter1 = shape1.perimeter();
    double perimeter2 = shape2.perimeter();

    if (perimeter1 < perimeter2) {
      return -1;
    } else if (perimeter1 > perimeter2) {
      return 1;
    } else {
      return 0;
    }
  }
}
