package shujiu;

import java.util.Random;

public class BLALA extends T2 {
    public static class SequenceList<T> {
        private T[] elements;
        private int maxSize;
        private int currentSize;

        @SuppressWarnings("unchecked")
        public SequenceList(int size) {
            this.maxSize = size;
            this.elements = (T[]) new Object[size];
            this.currentSize = 0;
        }

        public void add(T value, int index) {
            if (index < 1 || index > currentSize + 1) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            if (currentSize >= maxSize) {
                throw new IllegalStateException("List is full");
            }

            for (int i = currentSize; i >= index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index - 1] = value;
            currentSize++;}
        public int size() {
            return currentSize;
        }

        public T value(int index) {
            if (index < 1 || index > currentSize) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            return elements[index - 1];
        }

        public void nextOrder() {
            for (int i = 0; i < currentSize; i++) {
                System.out.print(elements[i] + " ");
            }
            System.out.println();
        }

        // 混洗方法
        public SequenceList<T> shuffle() {
            SequenceList<T> shuffledList = new SequenceList<>(this.currentSize);
            Random rand = new Random();

            while (currentSize > 0) {
                int pos = rand.nextInt(currentSize); // 生成 0 到 currentSize-1 的随机数
                shuffledList.add(this.value(pos + 1), shuffledList.size() + 1); // 使用 add 方法
                this.remove(pos + 1); // 移除元素
            }

            return shuffledList;
        }

        public void remove(int index) {
            if (index < 1 || index > currentSize) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            // 移动元素
            for (int i = index - 1; i < currentSize - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[currentSize - 1] = null; // 清空最后一个元素
            currentSize--;
        }
    }
    public static void main(String[] args) {
        SequenceList<Integer> La = new SequenceList<Integer>(10);
        SequenceList<Integer> Lb = new SequenceList<Integer>(5);
        SequenceList<Integer> Lc = new SequenceList<Integer>(5);
        for (int i = 0; i < 10; i++) {
            La.add(i, i + 1);
        }
        System.out.println("混洗之前La的数据状态");
        La.nextOrder();
        La = La.shuffle();
        System.out.println("混洗之后La的数据状态");
        La.nextOrder();
        for (int i = 0; i < La.size(); i++) { // 使用 La.size()
            if (i % 2 == 0) {
                Lb.add(La.value(i + 1), Lb.size() + 1);
            } else {
                Lc.add(La.value(i + 1), Lc.size() + 1);
            }
        }

        System.out.println("分发之后Lb的数据状态：");
        Lb.nextOrder();
        System.out.println("分发之后Lc的数据状态：");
        Lc.nextOrder();
    }
}
