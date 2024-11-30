package shujiu;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * @description: 自定义链表类
 * @author ybh20
 * @date 2024/10/20 09:31
 */
class CustomLinkedList<T> {
    private Node<T> head;
    private int size;

    public CustomLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * @description: 合并两个有序链表
 * @author ybh20
 * @date 2024/10/20 09:31
 */
public class Test2_3 {

    public static <T extends Comparable<T>> void mergeLists(CustomLinkedList<T> La, CustomLinkedList<T> Lb, CustomLinkedList<T> Lc) {
        Node<T> pa = La.getHead();
        Node<T> pb = Lb.getHead();
        Node<T> pc = Lc.getHead();

        while (pa != null && pb != null) {
            if (pa.data.compareTo(pb.data) <= 0) {
                Lc.add(pa.data);
                pa = pa.next;
            } else {
                Lc.add(pb.data);
                pb = pb.next;
            }
        }

        while (pa != null) {
            Lc.add(pa.data);
            pa = pa.next;
        }

        while (pb != null) {
            Lc.add(pb.data);
            pb = pb.next;
        }

        La.clear();
        Lb.clear();
    }

    public static void main(String[] args) {
        int[] a = {12, 23, 35, 49, 56};
        int[] b = {10, 15, 20};

        CustomLinkedList<Integer> La = new CustomLinkedList<>();
        CustomLinkedList<Integer> Lb = new CustomLinkedList<>();
        CustomLinkedList<Integer> Lc = new CustomLinkedList<>();

        for (int i : a) {
            La.add(i);
        }
        System.out.println("单链表La中的数据元素为");
        La.printList();

        for (int j : b) {
            Lb.add(j);
        }
        System.out.println("单链表Lb中的数据元素为");
        Lb.printList();

        mergeLists(La, Lb, Lc);
        System.out.println("合并后的单链表Lc中的数据元素为");
        Lc.printList();
    }
}


