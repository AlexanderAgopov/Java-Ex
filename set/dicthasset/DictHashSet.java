package set.dicthasset;
import java.util.List;
import java.util.Iterator;
public class DictHashSet<T> implements Set1<T> {
	
	private static final int DEFAULT_CAPACITY = 2;
	private static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private List[] set;
	private float loadFactor;
	private int treshold;
	private int size;
	
	
	
	public DictHashSet(int capacity, float loadFactor) {
		this.set = new List[capacity];
		this.loadFactor = loadFactor;
		this.treshold = (int) (this.set.length * this.loadFactor);
	}

	@Override
	public Iterator<SetEntry<T>> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T put(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
