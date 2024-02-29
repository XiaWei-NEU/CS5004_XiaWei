import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

  @Test(expected = IllegalArgumentException.class)
  public void testToString20() {
    Card card = new Card(Card.Suit.HEARTS, 20);
    assertEquals("Card{suit=HEARTS, rank=20}", card.toString());
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
  public void testEqualsSameObject() {
    Card card1 = new Card(Card.Suit.SPADES, 7);

    assertTrue(card1.equals(card1));
  }

  @Test
  public void testEqualsNullOject() {
    Card card1 = new Card(Card.Suit.SPADES, 7);

    assertFalse(card1.equals(null));
  }

  @Test
  public void testCompareTo() {
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    assertTrue(card1.compareTo(card2) > 0);
    assertTrue(card2.compareTo(card1) < 0);
    assertEquals(0, card1.compareTo(card1));
  }

  @Test
  public void test_equal_cards_same_hashcode() {
    Card card1 = new Card(Card.Suit.CLUBS, 5);
    Card card2 = new Card(Card.Suit.CLUBS, 5);
    assertEquals(card1.hashCode(), card2.hashCode());
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_null_suit_throws_exception() {
    Card card = new Card(null, 5);
    card.hashCode();
  }

  @Test(expected = IllegalArgumentException.class)
  public void test_negative_rank_throws_exception() {
    Card card = new Card(Card.Suit.CLUBS, -1);
    card.hashCode();
  }

}