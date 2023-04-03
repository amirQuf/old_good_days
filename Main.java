import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> ar1 = new LinkedList<>();
        int[] ar2 = new int[10000];
        int index = 0;
        LinkedList<Integer> ar3 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] <= 99) {
                ar1.add(arr[i]);
            } else if (arr[i] > 999) {
                ar2[index] = arr[i];
                index++;
            } else if (arr[i] > 99 && arr[i] < 999) {
                ar3.add(arr[i]);
            }
        }
        LinkedList<Integer> linkedList = combSort(ar1, ar2, index, ar3);
        String s =linkedList.toString()
                .replace(",", "")
                .replace("[", "")
                .replace("]", "")
                .trim();

        System.out.println(s);
    }

    public static LinkedList<Integer> combSort(LinkedList<Integer> ar1,
                                               int[] ar2, int n,
                                               LinkedList<Integer> ar3) {
        LinkedList<Integer> bs=new LinkedList<>();
        LinkedList<Integer> cs=new LinkedList<>();
        LinkedList<Integer> rs= new LinkedList<>();
        if (!ar1.isEmpty()) {
             bs = bucketSort(ar1);
        }
        if (n!=0) {
            cs = countingSort(ar2, n);
        }
        if (!ar3.isEmpty()) {
             rs = bucketSort(ar3);
        }
        bs.addAll(rs);
        bs.addAll(cs);
        return bs;
    }

    private static LinkedList<Integer> bucketSort(LinkedList<Integer> a) {
        if (a.size() == 1) return a;
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for (int i = 0; i <= 99; i++) {
            list.add(new LinkedList<>());
        }
        for (int i = 0; i < a.size(); i++) {
            list.get(a.get(i)).add(a.get(i));
        }
        a.clear();
        for (int i = 0; i < list.size(); i++) {
            LinkedList<Integer> list1 = new LinkedList<>(list.get(i));
            for (int j = 0; j < list1.size(); j++) {
                a.add(list1.get(j));
            }
        }
        return a;
    }

    private static LinkedList<Integer> radixSort(LinkedList<Integer> a) {
        if (a.size() == 1) {
            return a;
        }
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new LinkedList<>());
        }

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < a.size(); i++) {
                int index = (int) (a.get(i) / Math.pow(10, j)) % 10;
                list.get(index).add(a.get(i));
            }
            a.clear();
            for (int linklist = 0; linklist < list.size(); linklist++) {
                for (int node = 0; node < list.get(linklist).size(); node++) {
                    a.add(list.get(linklist).get(node));
                }
                list.get(linklist).clear();
            }
        }
        return a;
    }

    private static LinkedList<Integer> countingSort(int[] a, int index) {
        if(a.length==1){
            LinkedList<Integer> linkedList= new LinkedList<>();
            linkedList.add(a[0]);
            return linkedList;
        }
        int[] count = new int[10000];
        int[] c = new int[index];
        for (int i = 0; i < index; i++) {
            c[i] = a[i];
        }
        for (int i = 0; i < c.length; i++) {
            ++count[c[i]];
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] b = new int[index];
        for (int i = c.length - 1; i >= 0; i--) {
            b[count[c[i]] - 1] = c[i];
            --count[c[i]];
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < b.length; i++) {
            linkedList.add(b[i]);
        }
        return linkedList;
    }
}