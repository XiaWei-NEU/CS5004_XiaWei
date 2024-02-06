package HW1;

// Fraction interface
public interface Fraction extends Comparable<Fraction> {

  /**
   * Gets the numerator of the fraction.
   *
   * @return The numerator.
   */
  int getNumerator();

  /**
   * Sets the numerator of the fraction.
   *
   * @param numerator The new numerator.
   * @throws IllegalArgumentException If the fraction becomes invalid.
   */
  void setNumerator(int numerator);

  /**
   * Gets the denominator of the fraction.
   *
   * @return The denominator.
   */
  int getDenominator();

  /**
   * Sets the denominator of the fraction.
   *
   * @param denominator The new denominator.
   * @throws IllegalArgumentException If the denominator is not positive.
   */
  void setDenominator(int denominator);

  /**
   * Returns the scientific value (decimal) of the fraction.
   *
   * @return The decimal value of the fraction.
   */
  double toDouble();

  /**
   * Returns a simplified string representation of the fraction.
   *
   * @return The string representation of the fraction in simplest form.
   */
  String toString();

  /**
   * Returns the reciprocal of the fraction.
   *
   * @return The reciprocal of the fraction.
   * @throws ArithmeticException If the numerator is 0.
   */
  Fraction reciprocal();

  /**
   * Adds another fraction to this fraction and returns the result as a new fraction.
   *
   * @param other The fraction to add.
   * @return The result of adding the fractions.
   */
  Fraction add(Fraction other);
}
