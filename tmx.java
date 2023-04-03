import java.util.Scanner;

public class tmx {
    private String first_name;
    private String second_name;
    private int lessons;    //tedad dars
    private double mark;   //nomre
    private int vahed;      //0_4
    public int t_vahed = 0;  //kol  vahed
    private double sum = 0;

    public tmx() {
        first_name = "John";
        second_name = "Doe";
    }

    public void setLessons(int lessons) {

        this.lessons = lessons;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setVahed(int vahed) {
        this.vahed = vahed;
    }

    public double getSum() {
        return sum;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    public int getLessons() {
        return lessons;
    }

    public double getMark() {
        return mark;
    }

    public int getVahed() {
        return vahed;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }
    public void avg(){
        sum += vahed * mark ;
        t_vahed += vahed ;
    }
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        int m = Input.nextInt();//0_100
        for (int i = 1; i <= m; i++) {
            tmx s = new tmx();
            s.setFirst_name(Input.next());
            s.setSecond_name(Input.next());
            s.setLessons(Input.nextInt());
            for (int j = 1; j <= s.getLessons(); j++) {
                s.setVahed(Input.nextInt());
                s.setMark(Input.nextDouble());
                s.avg();
            }
            System.out.format("%s %s: %.2f\n",s.getFirst_name() , s.second_name , s.getSum()/s.t_vahed);
        }
    }
}
