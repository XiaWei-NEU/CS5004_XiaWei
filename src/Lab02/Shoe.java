package Lab02;

/**
 * This class represents a Shoe. A shoe has a type, color, brand and size
 */
public class Shoe {
  private final String type;
  private final String color;
  private final String brand;
  private final double size;

  /**
   * Construct a Shoe object that has the type, color, brand and size
   *
   * @param type  the type to be given to this Shoe
   * @param color the color to be given to this Shoe
   * @param brand  the brand to be assigned to this Shoe
   * @param size  the brand to be assigned to this Shoe
   */
  public Shoe(String type, String color, String brand, double size) {
      this.type = type;
      this.color = color;
      this.brand = brand;
      this.size = size;
  }

  /**
   * Return the type of this shoe
   *
   * @return the type of this shoe
   */
  public String getType() {
    return this.type;
  }

  /**
   * Return the color of this book
   *
   * @return the color of this book
   */
  public String getColor() {
    return this.color;
  }

  /**
   * Return the brand of this book
   *
   * @return the brand of this book
   */
  public String getBrand() {
    return this.brand;
  }

  /**
   * Return the size of this book
   *
   * @return the size of this book
   */
  public double getSize() {
    return this.size;
  }

  /**
   * Return the attributes of this shoe
   *
   * @return the attributes of this shoe
   */
  public String getAttr() {
    return this.type + " " + this.color + " " + this.brand + " " + this.size;
  }
}
