package Lab02;

public class ShoeTest {
  /**
   * A JUnit test class for the shoe class
   */
  public static void main(String[] args) {
    /*
      A test function for the shoe class
     */
    Shoe shoe1 = new Shoe("Running", "White", "Nike", 9);
    System.out.println(shoe1.getType()); // Display the string.
    System.out.println(shoe1.getColor());
    System.out.println(shoe1.getBrand());
    System.out.println(shoe1.getSize());
    System.out.println(shoe1.getAttr());
  }

}
