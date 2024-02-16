import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Implementation of the Hand interface using an ArrayList.
 *
 * @param <C> the type of elements in the hand
 */
public class HandImpl<C> implements Hand<C> {
  private ArrayList<C> cards;

  /**
   * Constructs an empty hand.
   */
  public HandImpl() {
    cards = new ArrayList<>();
  }

  @Override
  public Hand<C> add(C c) {
    cards.add(c);
    return this;
  }

  @Override
  public Hand<C> discard(int index) {
    if (index >= 0 && index < cards.size()) {
      cards.remove(index);
    }
    return this;
  }

  @Override
  public C get(int index) {
    if (index >= 0 && index < cards.size()) {
      return cards.get(index);
    }
    return null;
  }

  @Override
  public int getSize() {
    return cards.size();
  }

  @Override
  public boolean isEmpty() {
    return cards.isEmpty();
  }

  @Override
  public int find(C c) {
    return cards.indexOf(c);
  }

  @Override
  public void sortHand(Function<C, Integer> comparisonFunction) {
    Collections.sort(cards, (c1, c2) -> comparisonFunction.apply(c1) - comparisonFunction.apply(c2));
  }

  @Override
  public Hand<C> getHand(Predicate<C> filter) {
    HandImpl<C> filteredHand = new HandImpl<>();
    for (C card : cards) {
      if (filter.test(card)) {
        filteredHand.add(card);
      }
    }
    return filteredHand;
  }

  @Override
  public int rankSum() {
    int sum = 0;
    for (C card : cards) {
      // Assuming the card has a method to get the rank
      sum += ((Card) card).getRank();
    }
    return sum;
  }

  @Override
  public <D> Hand<D> getMap(Function<C, D> f) {
    HandImpl<D> mappedHand = new HandImpl<>();
    for (C card : cards) {
      mappedHand.add(f.apply(card));
    }
    return mappedHand;
  }
}