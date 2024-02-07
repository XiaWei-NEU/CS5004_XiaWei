package HW1;

/**
 * A class representing a fraction with an integer numerator and a positive integer denominator.
 */
public class FractionImpl implements Fraction {

  private int numerator;
  private int denominator;

  /**
   * Constructs a FractionImpl object with the given numerator and denominator.
   *
   * @param numerator   The numerator of the fraction.
   * @param denominator The denominator of the fraction (must be positive).
   * @throws IllegalArgumentException If the denominator is zero.
   */
  public FractionImpl(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Denominator cannot be zero");
    }

    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    this.numerator = numerator;
    this.denominator = denominator;
  }

  /**
   * Gets the numerator of the fraction.
   *
   * @return The numerator of the fraction.
   */
  @Override
  public int getNumerator() {
    return numerator;
  }

  /**
   * Sets the numerator of the fraction.
   *
   * @param numerator The new numerator value.
   */
  @Override
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  /**
   * Gets the denominator of the fraction.
   *
   * @return The denominator of the fraction.
   */
  @Override
  public int getDenominator() {
    return denominator;
  }

  /**
   * Sets the denominator of the fraction.
   *
   * @param denominator The new denominator value (must be positive).
   * @throws IllegalArgumentException If the denominator is not positive.
   */
  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive");
    }

    this.denominator = denominator;
  }

  /**
   * Returns the scientific value (decimal) of the fraction.
   *
   * @return The decimal value of the fraction.
   */
  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  /**
   * Returns a simplified string representation of the fraction.
   *
   * @return The string representation of the fraction in simplest form.
   */
  @Override
  public String toString() {
    int gcd = gcd(Math.abs(numerator), denominator);
    int simplifiedNumerator = numerator / gcd;
    int simplifiedDenominator = denominator / gcd;

    return simplifiedNumerator + " / " + simplifiedDenominator;
  }

  /**
   * Returns the reciprocal of the fraction.
   *
   * @return The reciprocal of the fraction.
   * @throws ArithmeticException If the numerator is zero.
   */
  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Reciprocal undefined for zero numerator");
    }

    return new FractionImpl(denominator, numerator);
  }

  /**
   * Adds another fraction to this fraction and returns the result as a new fraction.
   *
   * @param other The fraction to add.
   * @return The result of adding the fractions.
   */
  @Override
  public Fraction add(Fraction other) {
    int commonDenominator = this.denominator * other.getDenominator();
    int sumNumerator = (this.numerator * other.getDenominator()) + (other.getNumerator() * this.denominator);

    return new FractionImpl(sumNumerator, commonDenominator);
  }

  /**
   * Compares this fraction with another fraction.
   *
   * @param other The fraction to compare.
   * @return A negative integer if this fraction is less than the other, a positive integer if greater, and 0 if equal.
   */
  @Override
  public int compareTo(Fraction other) {
    int crossProduct1 = this.numerator * other.getDenominator();
    int crossProduct2 = other.getNumerator() * this.denominator;

    return Integer.compare(crossProduct1, crossProduct2);
  }

  // Private method to calculate the greatest common divisor (GCD) using Euclid's algorithm.
  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}
