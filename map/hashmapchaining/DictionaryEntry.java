package map.hashmapchaining;
/**
 * This class is used by Dictionary abstract data type (ADT).
 * It encapsulates Key and Value objects.
 * @author a
 *
 * @param <K> - type of the keys.
 * @param <V> - type of the values.
 */
public class DictionaryEntry<K, V> {
	private K key;
	private V value;

	public DictionaryEntry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public V getValue() {
		return value;
	}

	@Override
	public String toString() {
		return String.format("[%s, %s]", key, value);
	}

}
