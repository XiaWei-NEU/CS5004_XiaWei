import java.util.Comparator;
import java.util.Objects;

/**
 * Represents a playing card with a suit and rank.
 */
public class Card implements Comparable<Card> {

  public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}

  private Suit suit;
  private int rank;

  /**
   * Constructs a new Card with the specified suit and rank.
   *
   * @param suit the suit of the card
   * @param rank the rank of the card
   */
  public Card(Suit suit, int rank) {
    this.suit = suit;
    this.rank = rank;
  }

  /**
   * Gets the suit of the card.
   *
   * @return the suit of the card
   */
  public Suit getSuit() {
    return suit;
  }

  /**
   * Gets the rank of the card.
   *
   * @return the rank of the card
   */
  public int getRank() {
    return rank;
  }

  /**
   * Gets the color of the card.
   *
   * @return the color of the card ("RED" or "BLACK")
   */
  public String getColor() {
    if (suit == Suit.DIAMONDS || suit == Suit.HEARTS) {
      return "RED";
    } else {
      return "BLACK";
    }
  }

  /**
   * Returns a string representation of the card.
   *
   * @return a string representation of the card
   */
  @Override
  public String toString() {
    return "Card{" +
        "suit=" + suit +
        ", rank=" + rank +
        '}';
  }

  /**
   * Checks if this card is equal to another card.
   *
   * @param obj the object to compare to
   * @return true if the cards are equal, false otherwise
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Card other = (Card) obj;
    return this.suit == other.suit && this.rank == other.rank;
  }

  /**
   * Generates a hash code for the card.
   *
   * @return the hash code of the card
   */
  @Override
  public int hashCode() {
    return Objects.hash(suit, rank);
  }

  /**
   * Compares this card to another card based on rank.
   *
   * @param other the card to compare to
   * @return a negative integer if this card is less than the other card, zero if they are equal, or
   * a positive integer if this card is greater
   */
  @Override
  public int compareTo(Card other) {
    return Integer.compare(this.rank, other.rank);
  }

  /**
   * Comparator for comparing cards based on suit.
   */
  public static Comparator<Card> suitComparator = Comparator.comparing(card -> card.suit);
}