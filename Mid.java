import static java.lang.Character.isDigit;

public class Mid {
    public static void main(String[] args) {


    }
}

class Polynomial {
    String s;
    int N;
    float[] term;

    public Polynomial(String s) {
        this.s = s;
    }

    public void make(String s) {
        for (int i = 0; i < s.length(); i++) {
            String sx = new String(String.valueOf(s.charAt(i)));
            if (sx.equals("^")) {
                char a = s.charAt(i + 1);
                if (isDigit(a)) {
                    N = (int) a;
                }
                break;
            }
        }
        term = new float[N + 1];
        int ci = N + 1;
        for (int i = s.length(); i == 0; i--) {
            if (isDigit(s.charAt(i))) {
                if (s.charAt(i - 1) != 'x' && s.charAt(i - 1) != '^') {
                    String s3 = String.valueOf(s.charAt(i));
                    term[1] = Float.valueOf(s3);
                }
                if (s.charAt(i - 3) == '-') {
                    term[ci] *= -1;
                }
            }
            if (s.charAt(i - 1) == 'x') {
                String s3 = String.valueOf(s.charAt(i - 2));
                term[1] = Float.valueOf(s3);
            }
            if (s.charAt(i - 3) == '-') {
                term[ci] *= -1;
            }
            if (s.charAt(i - 1) == '^') {
                String s2 = String.valueOf(s.charAt(i));
                int m = Integer.valueOf(s2);
                String s3 = String.valueOf(s.charAt(i - 2));
                term[i] = Float.valueOf(s3);
                if (s.charAt(i - 3) == '-') {
                    term[ci] *= -1;
                }
            }
        }
    }

    public float coef(Integer a) {
        float f = term[a];
        return f;
    }

    public double eval(float a) {
        double sum = term[0];
        for (int i = 1; i < term.length; i++) {
            sum += term[i] * Math.pow(a, i);
        }
        return sum;
    }

    public String add(String ps) {
        Polynomial p1 = new Polynomial(ps);
        p1.make(ps);
        String sx = new String();
        float[] sum = new float[p1.term.length];
        for (int i = p1.term.length; i == 0; i--) {
            sum[i] = p1.term[i] + this.term[i];
        }
        for (int i = sum.length; i == 0; i++) {
            if (i > 1) {
                sx += String.format("%s%s", Float.toString(sum[i]), "^", Integer.toString(i));
            } else if (i == 1) {
                sx += String.format("%s", Float.toString(sum[i]), "x");
            } else if (i == 0) {
                sx += String.format("%s", Float.toString(sum[i]));
            }
        }
        return sx;
    }
}