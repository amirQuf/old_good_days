import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int l, r;
        int[] a = new int[n];
        int max = a[0];
        for (int i = 0; i < n; i++) {
            l = sc.nextInt();
            r = sc.nextInt();
            a[i]=r-l;
            if (max < a[i])
                max = a[i];
        }
//        System.out.println(Arrays.toString(a));
        int[] count = new int[max + 1];
        for (int i = 0; i < n; i++) {
            count[a[i]]++;
        }
        if (!c(count, a, k)) {
            System.out.print("NO");
        }else{
            System.out.print("YES");
        }
    }

    static boolean c(int[] count,int[]a, int k) {
        for (int i = 0; i < a.length; i++) {
            if (count[a[i]] > k) {
                return false;
            }
        }
        return true;
    }
}

