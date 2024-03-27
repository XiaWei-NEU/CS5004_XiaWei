package Lab09;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyPanelTest {

  @Test
  public void testRegenApplePositive() {
    MyPanel pannel = new MyPanel();
    pannel.regenApple();

    assertTrue(pannel.getAppleLoc().getX() >= 0 && pannel.getAppleLoc().getX() < 400);
    assertTrue(pannel.getAppleLoc().getY() >= 0 && pannel.getAppleLoc().getY() < 400);

    assertEquals(0, pannel.getAppleLoc().getX() % pannel.getDotSize(), 0);
    assertEquals(0, pannel.getAppleLoc().getY() % pannel.getDotSize(), 0);
  }

  @Test
  public void testRegenAppleNegative() {
    MyPanel pannel = new MyPanel();
    pannel.regenApple();

    assertFalse(pannel.getAppleLoc().getX() < 0 || pannel.getAppleLoc().getX() >= 400);
    assertFalse(pannel.getAppleLoc().getY() < 0 || pannel.getAppleLoc().getY() >= 400);

    assertNotEquals(1, pannel.getAppleLoc().getX() % pannel.getDotSize());
    assertNotEquals(1, pannel.getAppleLoc().getY() % pannel.getDotSize());
  }

}