import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;
import org.junit.Test;

public class HandImplTest {

  @Test
  public void testAddAndGet() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    hand.add(card1);
    hand.add(card2);

    assertEquals(card1, hand.get(0));
    assertEquals(card2, hand.get(1));
  }

  @Test
  public void testGetSize() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    hand.add(card1);
    hand.add(card2);

    assertEquals(2, hand.getSize());
  }

  @Test
  public void testIsEmpty() {
    HandImpl<Card> emptyHand = new HandImpl<>();
    HandImpl<Card> nonEmptyHand = new HandImpl<>();
    Card card = new Card(Card.Suit.HEARTS, 10);

    assertTrue(emptyHand.isEmpty());

    nonEmptyHand.add(card);
    assertFalse(nonEmptyHand.isEmpty());
  }

  @Test
  public void testDiscard() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    hand.add(card1);
    hand.add(card2);

    hand.discard(0);
    assertEquals(card2, hand.get(0));
    assertEquals(1, hand.getSize());
  }

  @Test
  public void testFind() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);

    hand.add(card1);
    hand.add(card2);

    assertEquals(0, hand.find(card1));
    assertEquals(1, hand.find(card2));
    assertEquals(-1, hand.find(new Card(Card.Suit.DIAMONDS, 2)));
  }

  @Test
  public void testSortHand() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);
    Card card3 = new Card(Card.Suit.HEARTS, 7);

    hand.add(card1);
    hand.add(card2);
    hand.add(card3);

//    hand.sortHand(Card::getRank);
    hand.sortHand(Comparator.comparingInt(Card::getRank));
    assertEquals(card2, hand.get(0));
    assertEquals(card3, hand.get(1));
    assertEquals(card1, hand.get(2));
  }

  @Test
  public void testGetHand() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);
    Card card3 = new Card(Card.Suit.HEARTS, 7);

    hand.add(card1);
    hand.add(card2);
    hand.add(card3);

    Predicate<Card> filter = card -> card.getSuit() == Card.Suit.HEARTS;
    HandImpl<Card> filteredHand = (HandImpl<Card>) hand.getHand(filter);

    assertEquals(2, filteredHand.getSize());
    assertEquals(card1, filteredHand.get(0));
    assertEquals(card3, filteredHand.get(1));
  }

  @Test
  public void test_GetHand2() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card = new Card(Card.Suit.HEARTS, 10);
    hand.add(card);

    // Single-method named class
    class Filter implements Predicate<Card> {
      @Override
      public boolean test(Card card) {
        return card.getSuit() == Card.Suit.HEARTS;
      }
    }

    // Anonymous class
    Predicate<Card> filter = new Predicate<Card>() {
      @Override
      public boolean test(Card card) {
        return card.getSuit() == Card.Suit.HEARTS;
      }
    };

    // Lambda expression
    Predicate<Card> lambdaFilter = cards -> card.getSuit() == Card.Suit.HEARTS;

    HandImpl<Card> filteredHand1 = (HandImpl<Card>) hand.getHand(new Filter());
    HandImpl<Card> filteredHand2 = (HandImpl<Card>) hand.getHand(filter);
    HandImpl<Card> filteredHand3 = (HandImpl<Card>) hand.getHand(lambdaFilter);

    assertEquals(1, filteredHand1.getSize());
    assertEquals(card, filteredHand1.get(0));

    assertEquals(1, filteredHand2.getSize());
    assertEquals(card, filteredHand2.get(0));

    assertEquals(1, filteredHand3.getSize());
    assertEquals(card, filteredHand3.get(0));
  }

  @Test
  public void testRankSum() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);
    Card card3 = new Card(Card.Suit.HEARTS, 7);
    Card card4 = new Card(Card.Suit.HEARTS, 4);
    Card card5 = new Card(Card.Suit.CLUBS, 5);
    Card card6 = new Card(Card.Suit.HEARTS, 6);

    hand.add(card1);
    hand.add(card2);
    hand.add(card3);

    assertEquals(22, hand.rankSum());

    hand.add(card4);
    hand.add(card5);
    hand.add(card6);

    assertEquals(37, hand.rankSum());
  }

  @Test
  public void testGetMap() {
    HandImpl<Card> hand = new HandImpl<>();
    Card card1 = new Card(Card.Suit.HEARTS, 10);
    Card card2 = new Card(Card.Suit.CLUBS, 5);
    Card card3 = new Card(Card.Suit.HEARTS, 7);

    hand.add(card1);
    hand.add(card2);
    hand.add(card3);

    Function<Card, String> mapFunction = Card::getColor;
    HandImpl<String> mappedHand = (HandImpl<String>) hand.getMap(mapFunction);

    assertEquals(3, mappedHand.getSize());
    assertEquals("RED", mappedHand.get(0));
    assertEquals("BLACK", mappedHand.get(1));
    assertEquals("RED", mappedHand.get(2));
  }
}