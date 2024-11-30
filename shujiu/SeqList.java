package shujiu;

public class SeqList {
    private Object[] elements;
    private int length;

    public SeqList(int capacity) {
        elements = new Object[capacity];
        length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public Object getElement(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        return elements[index];
    }

    public int locateElement(Object element) {
        for (int i = 0; i < length; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    public void insertElement(int index, Object element) {
        if (index < 0 || index > length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        if (length == elements.length) {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }
        for (int i = length; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        length++;
    }

    public void deleteElement(int index) {
        if (index < 0 || index >= length) {
            throw new IndexOutOfBoundsException("索引超出范围");
        }
        for (int i = index; i < length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        length--;
    }
}

class Main {
    public static void main(String[] args) {
        SeqList L = new SeqList(10);

        L.insertElement(0, "a");
        L.insertElement(1, "b");
        L.insertElement(2, "c");
        L.insertElement(3, "d");
        L.insertElement(4, "f");

        System.out.println("顺序表 L：");
        for (int i = 0; i < L.getLength(); i++) {
            System.out.print(L.getElement(i) + " ");
        }
        System.out.println();

        System.out.println("顺序表 L 的长度：" + L.getLength());

        System.out.println("判断顺序表是否为空：" + L.isEmpty());

        System.out.println("顺序表 L 的第 3 个元素：" + L.getElement(2));

        System.out.println("元素 c 的位置：" + L.locateElement("c"));

        L.insertElement(4, "e");

        System.out.println("插入元素 e 后的顺序表 L：");
        for (int i = 0; i < L.getLength(); i++) {
            System.out.print(L.getElement(i) + " ");
        }
        System.out.println();

        L.deleteElement(2);

        System.out.println("删除第 3 个元素后的顺序表 L：");
        for (int i = 0; i < L.getLength(); i++) {
            System.out.print(L.getElement(i) + " ");
        }
        System.out.println();
    }
}
