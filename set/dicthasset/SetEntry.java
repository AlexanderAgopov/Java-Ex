package set.dicthasset;

public class SetEntry<T> {

	private T element;

	public SetEntry(T element) {
		super();
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	@Override
	public String toString() {
		return String.format("[%s]", element);
	}

}
