import java.io.IOException;
import java.util.*;

public class Dar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> ms = new HashSet<>();
        LinkedList<k> lk = new LinkedList<>();
//        LinkedList<Integer> index = new LinkedList<>();
        int p, q;
        int c = 0;
        LinkedList<Integer> ps = new LinkedList<>();
        Set<Integer> qs = new HashSet<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < m; i++) {
            ms.add(sc.nextInt());
        }

        for (int i = 0; i < k; i++) {
            p = sc.nextInt();
            q = sc.nextInt();
            for (int j = 0; j < p; j++) {
                ps.add(sc.nextInt());
            }
            for (int j = 0; j < q; j++) {
                qs.add(sc.nextInt());
            }
            lk.add(new k(p, q, ps, qs));
            qs.clear();
            ps.clear();
        }
        int l = 0 ;
        Collections.sort(lk);
        for (int j = 0; j < lk.size(); j++) {
            for (int i = 0; i < lk.get(j).parr.size(); i++) {
                if (ms.contains(lk.get(j).parr.get(i))) {
                    c++;
                }
            }
            if (c == lk.get(j).p) {
                ms.addAll(lk.get(j).s);
//                System.out.println("yes "+lk.get(j));
            } else {
                l++;
                if(l==10000){
                    break;
                }
                lk.addLast(lk.get(j));
//                System.out.println("No "+lk.get(j));
            }
            c = 0;
        }
//        System.out.println(index);
//        for (int i = 0; i < index.size(); i++) {
//            for (int j = 0; j < lk.get(index.get(i)).parr.size(); j++) {
//                if (ms.contains(lk.get(index.get(i)).parr.get(j))) {
//                    c++;
//                }
//                if (c == lk.get(index.get(i)).p) {
//                    System.out.println("yes "+index.get(j));
//                    ms.addAll(lk.get(index.get(i)).s);
//                }else{
//                    System.out.println("NO"+index);
//                }
//            }
//        }
        System.out.println(ms.size());
        Iterator it = ms.iterator();
        for (int i = 0; i <ms.size()-1 ; i++) {
            System.out.print(it.next()+" ");
        }
        System.out.print(it.next());
    }
}

class k implements Comparable {
    int p;
    LinkedList<Integer> parr;
    Set<Integer> s;

    public k(int p, int q, LinkedList<Integer> parr, Set<Integer> s) {
        this.p = p;
        //this.q = q;
        this.parr = new LinkedList<>(parr);
        this.s = new LinkedHashSet<>(s);
    }

    @Override
    public String toString() {
        return "k{" +
                "p=" + p +
                ", parr=" + parr +
                ", s=" + s +
                '}';
    }

    @Override
    public int compareTo(Object o) {

        return this.p - ((k) o).p;
    }
}