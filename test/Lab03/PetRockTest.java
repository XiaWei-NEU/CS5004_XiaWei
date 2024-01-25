package Lab03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class PetRockTest {
  private PetRock rocky = new PetRock("Rocky");

  // Timeout rule:
  @Rule
  public Timeout globalTimeout = Timeout.seconds(10);

  @Before
  public void myTestSetup() throws Exception{
    rocky = new PetRock("Rocky");
  }
  
  @Test
  public void getName() throws Exception{
    assertEquals("Rocky", rocky.getName());
  }

  @Test (expected=RuntimeException.class)
  public void testUnhappy() throws Exception {
    rocky.playWithRock();
    rocky.getUnhappyMessage();
  }

  @Test
  public void testUnhappyToStart () throws Exception{
    assertFalse(rocky.isHappy());
  }

  @Test
  public void testHappyAfterPlay() throws Exception{
    rocky.playWithRock();
    assertTrue(rocky.isHappy());
  }

  @Ignore ("Exception throwing not yet defined")
  @Test (expected = IllegalStateException.class)
  public void nameFail() throws Exception{
    rocky.getHappyMessage();
  }

  @Test
  public void name() throws Exception{
    rocky.playWithRock();
    String msg = rocky.getHappyMessage();
    assertEquals("I'm happy!", msg);
  }

  @Test
  public void testFavName() throws Exception{
    assertEquals(42, rocky.getFavNumber());
  }

  @Test (expected = IllegalArgumentException.class)
  public void emptyNameFail() throws Exception{
    PetRock woofy = new PetRock("");
  }

  @Test //(timeout = 100) // in ms
  public void waitForHappyTimeout() throws Exception {
    rocky.waitTillHappy();
  }

  @Test
  public void testDoubleSame() {
    assertSame(rocky.getD1(), rocky.getD2());
  }

  @Test
  public void testToString() {
    String str = "PetRock: the name is " + rocky.getName() + ", the happy is " + rocky.isHappy() + ", the d1 is " + rocky.getD1();
    assertEquals(str, rocky.toString());
  }
}