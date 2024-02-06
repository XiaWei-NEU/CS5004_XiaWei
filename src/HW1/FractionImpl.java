package HW1;

public class FractionImpl implements Fraction {
  private int numerator;
  private int denominator;

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

  @Override
  public int getNumerator() {
    return numerator;
  }

  @Override
  public void setNumerator(int numerator) {
    this.numerator = numerator;
  }

  @Override
  public int getDenominator() {
    return denominator;
  }

  @Override
  public void setDenominator(int denominator) {
    if (denominator <= 0) {
      throw new IllegalArgumentException("Denominator must be positive");
    }

    this.denominator = denominator;
  }

  @Override
  public double toDouble() {
    return (double) numerator / denominator;
  }

  @Override
  public String toString() {
    int gcd = gcd(Math.abs(numerator), denominator);
    int simplifiedNumerator = numerator / gcd;
    int simplifiedDenominator = denominator / gcd;

    return simplifiedNumerator + " / " + simplifiedDenominator;
  }

  @Override
  public Fraction reciprocal() {
    if (numerator == 0) {
      throw new ArithmeticException("Reciprocal undefined for zero numerator");
    }

    return new FractionImpl(denominator, numerator);
  }

  @Override
  public Fraction add(Fraction other) {
    int commonDenominator = this.denominator * other.getDenominator();
    int sumNumerator = (this.numerator * other.getDenominator()) + (other.getNumerator() * this.denominator);

    return new FractionImpl(sumNumerator, commonDenominator);
  }

  @Override
  public int compareTo(Fraction other) {
    int crossProduct1 = this.numerator * other.getDenominator();
    int crossProduct2 = other.getNumerator() * this.denominator;

    return Integer.compare(crossProduct1, crossProduct2);
  }

  private static int gcd(int a, int b) {
    if (b == 0) {
      return a;
    }
    return gcd(b, a % b);
  }
}