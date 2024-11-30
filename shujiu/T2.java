package shujiu;

public class T2 {
    public static class SequenceList<T> {
        private T[] elements;
        private int size;

        public SequenceList(int capacity) {
            elements = (T[]) new Object[capacity];
            size = 0;
        }

        public void add(T element, int index) {
            if (index > size + 1 || index < 1) throw new IndexOutOfBoundsException("Index out of bounds");
            for (int i = size; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index - 1] = element;
            size++;
        }

        public T value(int index) {
            if (index > size || index < 1) throw new IndexOutOfBoundsException("Index out of bounds");
            return elements[index - 1];
        }

        public int size() {
            return size;
        }

        public void nextOrder() {
            for (int i = 0; i < size; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }
    }


}
