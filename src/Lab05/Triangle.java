package Lab05;

/**
 * The Triangle class represents a geometric triangle in a 2D space.
 * It extends the AbstractShape class and inherits common shape-related
 * functionalities such as area, perimeter, and resizing.
 */
public class Triangle extends AbstractShape {

  /** The second point of the triangle. */
  private Point2D point2;

  /** The third point of the triangle. */
  private Point2D point3;

  /**
   * Constructs a Triangle object with specified coordinates for its vertices.
   *
   * @param x1 The x-coordinate of the first vertex.
   * @param y1 The y-coordinate of the first vertex.
   * @param x2 The x-coordinate of the second vertex.
   * @param y2 The y-coordinate of the second vertex.
   * @param x3 The x-coordinate of the third vertex.
   * @param y3 The y-coordinate of the third vertex.
   * @throws IllegalArgumentException if the points are not unique.
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    super(new Point2D(x1, y1));
    this.point2 = new Point2D(x2, y2);
    this.point3 = new Point2D(x3, y3);

    // Check for uniqueness of points
    if (reference.equals(point2) || reference.equals(point3) || point2.equals(point3)) {
      throw new IllegalArgumentException("Triangle points must be unique.");
    }
  }

  /**
   * Calculates and returns the area of the triangle.
   *
   * @return The area of the triangle.
   */
  @Override
  public double area() {
    return 0.5 * Math.abs((reference.getX() - point3.getX()) * (point2.getY() - point3.getY()) -
        (point2.getX() - point3.getX()) * (reference.getY() - point3.getY()));
  }

  /**
   * Calculates and returns the perimeter of the triangle.
   *
   * @return The perimeter of the triangle.
   */
  @Override
  public double perimeter() {
    double side1 = reference.distance(point2);
    double side2 = point2.distance(point3);
    double side3 = point3.distance(reference);
    return side1 + side2 + side3;
  }

  /**
   * Resizes the triangle by a given factor. Creates and returns a new triangle
   * with adjusted coordinates based on the resizing factor.
   *
   * @param factor The factor by which the triangle should be resized.
   * @return The resized triangle.
   */
  @Override
  public Shape resize(double factor) {
    return new Triangle(
        reference.getX(),
        reference.getY(),
        point2.getX(),
        point2.getY(),
        point3.getX(),
        point3.getY()
    );
  }

  /**
   * Returns a string representation of the triangle, including the coordinates
   * of its three vertices.
   *
   * @return A string representation of the triangle.
   */
  @Override
  public String toString() {
    return String.format("Triangle: points (%.3f,%.3f), (%.3f,%.3f), (%.3f,%.3f)",
        reference.getX(), reference.getY(), point2.getX(), point2.getY(), point3.getX(), point3.getY());
  }
}
