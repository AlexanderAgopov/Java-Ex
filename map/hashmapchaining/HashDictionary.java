/**
 * 
 */
package map.hashmapchaining;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Implementation of {@link Dictionary1} interface using hash table. Collisions
 * are resolved by chaining.
 * 
 * @author a
 * @param K - the type of the keys
 * @param V - the tupe of the values
 */
public class HashDictionary<K, V> implements Dictionary1<K, V> {
	private static final int DEFAULT_CAPACITY = 2;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private List<DictionaryEntry<K, V>>[] table;
	private float loadFactor;
	private int treshold;
	private int size;

	public HashDictionary() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}

	@SuppressWarnings("unchecked")
	private HashDictionary(int capacity, float loadFactor) {
		// TODO Auto-generated constructor stub
		this.table = new List[capacity];
		this.loadFactor = loadFactor;
		this.treshold = (int) (this.table.length * this.loadFactor);
	}

	public List<DictionaryEntry<K, V>>[] getTable() {
		return table;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		Arrays.fill(this.table, null);
		this.size = 0;

	}

	private List<DictionaryEntry<K, V>> findChain(K key, boolean createIfMissing) {
		int index = key.hashCode();
		index = index % this.table.length;
		if (table[index] == null && createIfMissing) {
			table[index] = new ArrayList<DictionaryEntry<K, V>>();
		}
		return table[index];
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		List<DictionaryEntry<K, V>> chain = findChain(key, false);
		if (chain != null) {
			for (DictionaryEntry<K, V> dictionaryEntry : chain) {
				if (dictionaryEntry.getKey().equals(key)) {
					return dictionaryEntry.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public V put(K key, V value) {
		// TODO Auto-generated method stub
		List<DictionaryEntry<K, V>> chain = findChain(key, true);
		for (int i = 0; i < chain.size(); i++) {
			DictionaryEntry<K, V> entry = chain.get(i);
			if (entry.getKey().equals(key)) {
				// Key found -> replace its value with the new value
				DictionaryEntry<K, V> newEntry = new DictionaryEntry<K, V>(key, value);
				chain.set(i, newEntry);
				return entry.getValue();
			}
		}
		chain.add(new DictionaryEntry<K, V>(key, value));
		if (size++ >= treshold) {
			expand();
		}
		return null;
	}

	/**
	 * Expands the underling table.
	 */
	private void expand() {
		int newCapacity = 2 * this.table.length;
		List<DictionaryEntry<K, V>>[] oldTable = this.table;
		this.table = new List[newCapacity];
		this.treshold = (int) (newCapacity * this.loadFactor);
		for (List<DictionaryEntry<K, V>> oldChain : oldTable) {
			if (oldChain != null) {
				for (DictionaryEntry<K, V> dictionaryEntry : oldChain) {
					List<DictionaryEntry<K, V>> chain = findChain(dictionaryEntry.getKey(), true);
					chain.add(dictionaryEntry);
				}
			}
		}
	}

	@Override
	public boolean remove(K key) {
		// TODO Auto-generated method stub
		List<DictionaryEntry<K, V>> chain = findChain(key, false);
		if (chain != null) {
			for (int i = 0; i < chain.size(); i++) {
				DictionaryEntry<K, V> entry = chain.get(i);
				if (entry.getKey().equals(key)) {
					chain.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<DictionaryEntry<K, V>> iterator() {
		// TODO Auto-generated method stub
		List<DictionaryEntry<K, V>> entries = new ArrayList<DictionaryEntry<K, V>>(this.table.length);
		for (List<DictionaryEntry<K, V>> chain : this.table) {
			if (chain != null) {
				entries.addAll(chain);
			}
		}
		return entries.iterator();
	}

}
