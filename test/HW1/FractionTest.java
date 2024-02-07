package HW1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class FractionTest {
  @Test
  public void testFractionCreation() {
    Fraction fraction = new FractionImpl(2, 3);
    assertEquals(2, fraction.getNumerator());
    assertEquals(3, fraction.getDenominator());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testZeroDenominator() {
    new FractionImpl(1, 0);
  }

  @Test
  public void testToString() {
    Fraction fraction = new FractionImpl(4, 2);
    assertEquals("2 / 1", fraction.toString());
  }

  @Test
  public void testToDouble() {
    Fraction fraction = new FractionImpl(3, 4);
    assertEquals(0.75, fraction.toDouble(), 0.001);
  }

  @Test
  public void testReciprocal() {
    Fraction fraction = new FractionImpl(5, 7);
    Fraction reciprocal = fraction.reciprocal();
    assertEquals(7, reciprocal.getNumerator());
    assertEquals(5, reciprocal.getDenominator());
  }

  @Test(expected = ArithmeticException.class)
  public void testReciprocalZeroNumerator() {
    Fraction fraction = new FractionImpl(0, 3);
    fraction.reciprocal();
  }

  @Test
  public void testAdd() {
    Fraction fraction1 = new FractionImpl(1, 2);
    Fraction fraction2 = new FractionImpl(1, 4);
    Fraction sum = fraction1.add(fraction2);
    assertEquals(6, sum.getNumerator());
    assertEquals(8, sum.getDenominator());
  }

  @Test
  public void testCompareTo() {
    Fraction fraction1 = new FractionImpl(1, 2);
    Fraction fraction2 = new FractionImpl(3, 4);
    assertTrue(fraction1.compareTo(fraction2) < 0);
    assertTrue(fraction2.compareTo(fraction1) > 0);
    assertEquals(0, fraction1.compareTo(new FractionImpl(2, 4)));
  }

}
