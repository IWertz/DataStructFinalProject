
public class LinkedArray {
	Application[] array;
	int size = 0;

	public LinkedArray() {
		super();
		array = new Application[10];
	}

	public LinkedArray(int arraySize) {
		super();
		array = new Application[arraySize];
	}

	public LinkedArray(Application[] array) {
		this.array = new Application[array.length];
		for (Application app : array) {
			this.array[size] = app;
			size++;
		}
	}

	public LinkedArray(int arraySize, Application[] array) throws ListFullException {
		this.array = new Application[arraySize];
		if (this.array.length < array.length)
			throw new ListFullException();
		for (int i = 0; i < array.length; i++) {
			this.array[size] = array[i];
			size++;
		}
	}

	public void addLast(Application app) throws ListFullException {
		if (size >= array.length)
			throw new ListFullException();
		array[size] = app;
		size++;
	}

	public void add(int index, Application app) throws ListFullException {
		if (size >= array.length)
			throw new ListFullException();
		if (size > index) {
			for (int i = size - 1; i >= index; i--) {
				array[i + 1] = array[i];
			}
			array[index] = app;
			size++;
		} else if (size <= index) {
			array[size] = app;
			size++;
		}
	}

	public Application peekFirst() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		return array[0];
	}

	public Application removeFirst() throws ListEmptyException {
		if (size == 0)
			throw new ListEmptyException();
		Application app = array[0];
		if (size >= 1) {
			for (int i = 0; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
		}
		array[size - 1] = null;
		size--;
		return app;
	}

	public Application remove(int index) {
		if (size >= index) {
			Application app = array[index];
			for (int i = index; i < size - 1; i++) {
				array[i] = array[i + 1];
			}
			array[size - 1] = null;
			size--;
			return app;
		} else {
			return null;
		}
	}

	public int size() {
		return size;
	}

	public String printArray() {
		String print = "";
		for (int i = 0; i < size; i++) {
			print = print + array[i].toString() + " ";
		}
		return print;
	}
}