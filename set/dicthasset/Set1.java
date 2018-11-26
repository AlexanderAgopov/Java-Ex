package set.dicthasset;

/**
 * Interface that defines basic methods for the implementation of a dictionary
 * through set of elements.
 * 
 * @author a
 *
 * @param <T> - the type of the values
 */
public interface Set1<T> extends Iterable<SetEntry<T>> {
	/**
	 * Adds new element in the dictionary.
	 * 
	 * @param element - the element to be added
	 * @return <code> true </code> if such element exists and <code> false </code>
	 *         otherwise
	 */
	public T put(T element);

	/**
	 * Returns the specified element.
	 * 
	 * @param element - the element to be get
	 * @return the old element or null if such element does not exists in the
	 *         dictionary
	 */
	public T get(T element);

	/**
	 * Removes the element.
	 * 
	 * @param element - the element to be removed
	 * @return <code> true </code> if there is no such element in the dictionary, or
	 *         <code> false </code> otherwise.
	 */
	public boolean remove(T element);

	/**
	 * Checks if there are any elements in the dictionary.
	 * 
	 * @return <code> true </code> if the set is empty and <code> false </code>
	 *         otherwise
	 */
	public boolean isEmpty();

	/**
	 * Removes all elements from the dictionary.
	 */
	public void clear();

}
