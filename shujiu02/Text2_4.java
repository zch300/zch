package shujiu02;

class node<T> {
    T data;
    node<T> next;

    public node(T data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * @description: 自定义链表类
 * @author ybh20
 * @date 2024/10/20 10:07
 */
class customLinkedList<T> {
    private node<T> head;
    private int size;

    public customLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public node<T> getHead() {
        return head;
    }

    public void add(T data) {
        node<T> newNode = new node<>(data);
        if (head == null) {
            head = newNode;
            newNode.next = head; // 使链表形成环
        } else {
            node<T> current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head;
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

    public int size() {
        return size;
    }

    public boolean remove(node<T> p) {
        if (isEmpty()) {
            return false;
        }
        if (p == head) {
            if (head.next == head) {
                head = null;
            } else {
                node<T> current = head;
                while (current.next != head) {
                    current = current.next;
                }
                head = head.next;
                current.next = head;
            }
            size--;
            return true;
        }
        node<T> q = head;
        while (q.next != p) {
            q = q.next;
            if (q == head) {
                return false; // 节点不在链表中
            }
        }
        q.next = p.next;
        size--;
        return true;
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }
        node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }
}

/**
 * @description: 约瑟夫环问题
 * @author ybh20
 * @date 2024/10/20 10:07
 */
public class Text2_4 {

    public static customLinkedList<Integer> create(int n) {
        customLinkedList<Integer> list = new customLinkedList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        customLinkedList<Integer> L = create(6);
        int m = 1;
        node<Integer> p = L.getHead();
        System.out.println("6个人出局的顺序如下");
        while (L.size() > 1) {
            if (m == 5) {
                System.out.print(p.data + "\t");
                L.remove(p);
                m = 1; // 重置计数器为1
                p = p.next;
            } else {
                m++;
                p = p.next;
            }
        }
        System.out.println("\n最后未出局的人：" + L.getHead().data);
    }
}



