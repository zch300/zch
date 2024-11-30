package shujiu;

public class lalala extends T2 {

    public static <T extends Comparable<T>> void mergeList(SequenceList<T> La, SequenceList<T> Lb, SequenceList<T> Lc) {
        int i = 0, j = 0, k = 0;
        while (i < La.size() && j < Lb.size()) {
            if (La.value(i + 1).compareTo(Lb.value(j + 1)) <= 0) {
                Lc.add(La.value(i + 1), k + 1);
                i++;
            } else {
                Lc.add(Lb.value(j + 1), k + 1);
                j++;
            }
            k++;
        }
        while (i < La.size()) {
            Lc.add(La.value(i + 1), k + 1);
            i++;
            k++;
        }
        while (j < Lb.size()) {
            Lc.add(Lb.value(j + 1), k + 1);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] a = {12, 23, 34, 49, 56};
        int[] b = {10, 15, 20};
        SequenceList<Integer> La = new SequenceList<Integer>(5);
        SequenceList<Integer> Lb = new SequenceList<Integer>(3);
        SequenceList<Integer> Lc = new SequenceList<Integer>(8);

        for (int i = 0; i < a.length; i++) {
            La.add(a[i], i + 1);
        }
        System.out.println("顺序表La中的数据元素为：");
        La.nextOrder();

        for (int j = 0; j < b.length; j++) {
            Lb.add(b[j], j + 1);
        }
        System.out.println("顺序表Lb中的数据元素为：");
        Lb.nextOrder();

        mergeList(La, Lb, Lc);
        System.out.println("合并后的顺序表Lc中的数据元素为：");
        Lc.nextOrder();
    }
}
