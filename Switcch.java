import java.util.Scanner;

public class Switcch {

public static void main(String[] args) {
    int b = 0;
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    while (sc.hasNext()) {
            String op = sc.next();
            switch (op) {
                case "*": {
                    b = sc.nextInt();
                    a *= b;
                }
                break;
                case "/": {
                    b = sc.nextInt();
                    a /= b;
                }
                break;
                case "%": {
                    b = sc.nextInt();
                    a = a % b;
                }
                break;
            }
        }System.out.print(a);
}}