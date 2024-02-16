import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CardTest {

  @Test
  public void testGetSuit() {
    Card card = new Card(Card.Suit.HEARTS, 10);
    assertEquals(Card.Suit.HEARTS, card.getSuit());
  }

  @Test
  public void testGetRank() {
    Card card = new Card(Card.Suit.HEARTS, 10);
    assertEquals(10, card.getRank());
  }

  @Test
  public void testGetColor() {
    Card redCard = new Card(Card.Suit.HEARTS, 10);
    Card blackCard = new Card(Card.Suit.CLUBS, 5);

    assertEquals("RED", redCard.getColor());
    assertEquals("BLACK", blackCard.getColor());
  }

  @Test
  public void testToString() {
    Card card = new Card(Card.Suit.HEARTS, 10);
    assertEquals("Card{suit=HEARTS, rank=10}", card.toString());
  }

  @Test
  public void testEquals() {
    Card card1 = new Card(Card.Suit.SPADES, 7);
    Card card2 = new Card(Card.Suit.SPADES, 7);
    Card card3 = new Card(Card.Suit.DIAMONDS, 4);

    assertEquals(card1, card2);
    assertNotEquals(card1, card3);
  }

  @Test
  public void testCompareTo() {
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    assertTrue(card1.compareTo(card2) > 0);
    assertTrue(card2.compareTo(card1) < 0);
    assertEquals(0, card1.compareTo(card1));
  }
}