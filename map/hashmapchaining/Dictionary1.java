package map.hashmapchaining;

/**
 * Interface that defines basic methods needed for a class which maps keys to
 * values.
 * 
 * @author a
 * 
 * @param K - type of the keys.
 * @param V - type of the values.
 */
public interface Dictionary1<K, V> extends Iterable<DictionaryEntry<K, V>> {
	/**
	 * Adds specified value by specified key in the dictionary.If the key already
	 * exists its value is replaced by the new value and the old value is returned.
	 * 
	 * @param key   - key for the new value.
	 * @param value - value to be mapped with that key.
	 * @return the old value for the specified key or null if the key does not
	 *         exists.
	 * @throws NullPointerExcepton if specified key is null.
	 */
	public V put(K key, V value);

	/**
	 * Returns the value to which the specified key is mapped, or null if this map
	 * contains no mapping for the key.
	 * 
	 * @param key - the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this map
	 *         contains no mapping for the key
	 */
	public V get(K key);

	/**
	 * Removes the value mapped by the key.
	 * 
	 * @param key - the key whose associated value is to be removed.
	 * @return <code> true </code> if value for the specified key is present, or
	 *         <code> false </code> if there is no value with such key in the
	 *         dictionary
	 */
	public boolean remove(K key);

	/**
	 * Checks if there are any elements in the dictionary.
	 * 
	 * @return <code> true </code> if there are no elements in the dictionary, or
	 *         <code> false </code> otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Removes all elements from the dictionary.
	 */
	public void clear();

}
