import java.util.function.Function;
import java.util.function.Predicate;
import java.util.Comparator;

/**
 * Represents a hand of cards that can hold various types of elements.
 *
 * @param <C> the type of elements in the hand
 */
public interface Hand<C> {

  /**
   * Adds an element to the hand.
   *
   * @param c the element to add
   * @return the hand with the added element
   */
  Hand<C> add(C c);

  /**
   * Discards an element at the specified index from the hand.
   *
   * @param index the index of the element to discard
   * @return the hand without the discarded element
   */
  Hand<C> discard(int index);

  /**
   * Retrieves the element at the specified index from the hand.
   *
   * @param index the index of the element to retrieve
   * @return the element at the specified index
   */
  C get(int index);

  /**
   * Returns the number of elements currently in the hand.
   *
   * @return the size of the hand
   */
  int getSize();

  /**
   * Checks if the hand is empty.
   *
   * @return true if the hand is empty, false otherwise
   */
  boolean isEmpty();

  /**
   * Finds the index of the first occurrence of a specific element in the hand.
   *
   * @param c the element to find
   * @return the index of the element if found, -1 otherwise
   */
  int find(C c);

  /**
   * Sorts the hand based on a comparison function.
   *
   * @param comparator the function used for comparison
   */
  void sortHand(Comparator<C> comparator);
//  void sortHand(Function<C, Integer> comparisonFunction);


  /**
   * Returns a subset of the hand based on a predicate.
   *
   * @param filter the predicate used for filtering
   * @return a subset of the hand
   */
  Hand<C> getHand(Predicate<C> filter);

  /**
   * Calculates the sum of ranks of the cards in the hand.
   *
   * @return the sum of ranks
   */
  int rankSum();

  /**
   * Maps the elements in the hand to a different type using a function.
   *
   * @param f   the mapping function
   * @param <D> the type of elements after mapping
   * @return a new hand with elements of type D
   */
  <D> Hand<D> getMap(Function<C, D> f);
}