import java.util.Arrays;
import java.util.Scanner;

public class Dozed {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs dfs= new dfs(n);
        for (int i = 0; i < n; i++) {
           dfs. p[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (j > i && dfs.p[i] > dfs.p[j]) {
                    dfs.matris[i][j]=1;
                    dfs.matris[j][i]=1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            dfs.p[i]=0;
        }
        int c = 1;
        dfs.dfss(0, c);
        for (int i = 0; i < n; i++) {
            if (dfs.p[i] == 0) {
                dfs.dfss(i, ++c);
            }

        }
        System.out.print(dfs.p[n - 1]);
    }


}
class dfs{
    byte[][] matris= null;
//    boolean[] vi= null;
   int[] p = null;

    public dfs(int n) {
        this.matris = new byte[n][n];
        this.p =new int[n];
//        this.vi= new boolean[n];
    }

    void dfss(int w, int c) {
        p[w] = c;
//        vi[w]=true;
        for (int i = 0; i < matris.length; i++) {
            if (p[i] == 0 &&matris[w][i]==1) {
                dfss(i, c);
            }
        }
    }
}
