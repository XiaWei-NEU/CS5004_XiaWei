package HW2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Collections;

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

  /**
   * A description of the entire Java function.
   *
   * @param c description of parameter
   * @return description of return value
   */
  @Override
  public Hand<C> add(C c) {
    cards.add(c);
    return this;
  }

  /**
   * A description of the entire Java function.
   *
   * @param index description of parameter
   * @return description of return value
   */
  @Override
  public Hand<C> discard(int index) {
    if (index >= 0 && index < cards.size()) {
      cards.remove(index);
    }
    return this;
  }

  /**
   * Retrieves the element at the specified index in the list.
   *
   * @param index the index of the element to retrieve
   * @return the element at the specified index, or null if the index is out of range
   */
  @Override
  public C get(int index) {
    if (index >= 0 && index < cards.size()) {
      return cards.get(index);
    }
    return null;
  }

  /**
   * Returns the size of the cards collection.
   *
   * @return the size of the cards collection
   */
  @Override
  public int getSize() {return cards.size();}


  /**
   * Check if the collection of cards is empty.
   *
   * @return true if the collection is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {return cards.isEmpty();}

  /**
   * A description of the entire Java function.
   *
   * @param c description of parameter
   * @return description of return value
   */
  @Override
  public int find(C c) {return cards.indexOf(c);}


  /**
   * sort the hand using the specified comparator
   *
   * @param comparator the comparator to use for sorting
   * @return void
   */
  @Override
  public void sortHand(Comparator<C> comparator) {
    Collections.sort(cards, comparator);
  }

  /**
   * Gets the hand based on the given filter.
   *
   * @param filter the predicate to filter the hand
   * @return the hand containing the filtered cards
   */
  @Override
  public Hand<C> getHand(Predicate<C> filter) {
    HandImpl<C> filteredHand = new HandImpl<>();
//    for (C card : cards) {
//      if (filter.test(card)) {
//        filteredHand.add(card);
//      }
//    }
    cards.stream().filter(filter).forEach(filteredHand::add);
    return filteredHand;
  }

  /**
   * Calculates the sum of the ranks of the cards.
   *
   * @return the sum of the ranks
   */
  @Override
  public int rankSum() {
//    int sum = 0;
//    for (C card : cards) {
//      sum += ((Card) card).getRank();
//    }
//    return sum;

    return cards.stream().mapToInt(c -> ((Card) c).getRank()).sum();
  }

  /**
   * A method to map the elements of a Hand using a given function.
   *
   * @param f the function to apply to each element of the Hand
   * @return a new Hand containing the mapped elements
   */
  @Override
  public <D> Hand<D> getMap(Function<C, D> f) {
    HandImpl<D> mappedHand = new HandImpl<>();
//    for (C card : cards) {
//      mappedHand.add(f.apply(card));
//    }
    cards.stream().map(f).forEach(mappedHand::add);
    return mappedHand;
  }
}