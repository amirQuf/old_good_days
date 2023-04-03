import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Game game = new Game();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Student s = new Student();//n ta player migire
            game.add(s, sc.next(), (sc.nextInt()));
        }
        //array ra kamel mikonad
        while (sc.hasNext()) {
            if (sc.hasNextInt()) {
                int role_dice = sc.nextInt();//tas migire
                if(role_dice==6){
                game.InandOutin(role_dice);}
                else
                {
                    game.checkScore(role_dice);
                }
            } else {
                String end = sc.next();
            }
        }
        game.ShowWinner();
    }
}

enum first_guys {
    YOU_JUST_ENTERED, YOU_SHOULD_WAIT_MORE,
    NOW_YOU_CAN_SCORE;
}

enum second_guys {//enum bra term 2
    YOU_SHOULD_WAIT_ONE_STEP, NOW_YOU_CAN_SCORE;
}

enum king_bros {//enum bra slatin(term8)
    YOU_CAN_SCORE_ANYTIME_BOSS;
}

class Game {
    Student[] students = new Student[1000];
    int index = 0;
    private int turn = 0;

    public void add(Student student, String name, int kind) {
        students[index] = student;
        students[index].setName(name);
        students[index].setKind(kind);
        index++;
    }

    private first_guys manage1(int level) {
        first_guys fg = null;
        if (level == 1) {
            fg = first_guys.YOU_JUST_ENTERED;
        } else if (level == 2) {
            fg = first_guys.YOU_SHOULD_WAIT_MORE;
        } else if (level >= 3) {
            fg = first_guys.NOW_YOU_CAN_SCORE;
        }
        return fg;
    }

    private second_guys manage2(int level) {
        second_guys sg = null;
        if (level == 1) {
            sg = second_guys.YOU_SHOULD_WAIT_ONE_STEP;
        } else if (level >= 2) {
            sg = second_guys.NOW_YOU_CAN_SCORE;
        }
        return sg;
    }

    private king_bros manage8(int level) {
        king_bros king = null;
        if (level > 1) {
            king = king_bros.YOU_CAN_SCORE_ANYTIME_BOSS;
        }
        return king;
    }

    public void InandOutin(int roleDice) {
        if (roleDice == 6) {
            int six = 0;
            six += 6;
            int sixx;
            sixx = six / 6;
            if (sixx % 2 == 0) {//if in zog bood  ===az bazi hazf shode === emtyaz & level==0
                students[turn].setScore(0);
                students[turn].setlevel(0);
                students[turn].setIn_game(false);
               }else{  students[turn].setIn_game(true);}
               turn++;
              if (turn == index - 1) {
                    turn = 0;
                }
            }}
        public void checkScore ( int dice){
        if (students[turn].in_game &&students[turn].getKind()==1) {
            students[turn].level++;
            students[turn].f = manage1(students[turn].getLevel());
            if(students[turn].f ==first_guys.NOW_YOU_CAN_SCORE){
                students[turn].score++;
            }
            turn++;
            if(turn ==index-1){
                turn =0;
            }
        }
        else if ( students[turn].in_game &&students[turn].getKind()==2) {
            students[turn].level++;
            students[turn].s = manage2(students[turn].getLevel());
            if(students[turn].s ==second_guys.NOW_YOU_CAN_SCORE){
                students[turn].score++;
            }
            turn++;
            if(turn ==index-1){
                turn =0;
            }else if(students[turn].in_game &&students[turn].getKind()== 8){
               students[turn].level++;
               students[turn].k = manage8(students[turn].level);
               if(students[turn].k == king_bros.YOU_CAN_SCORE_ANYTIME_BOSS){
                   students[turn].score++;
               }
            }
        }
    }
    public void ShowWinner() {
        //in part sort  mikone nesbat be score
        for (int i = 0; i < index; i++) {
            for (int j = i + 1; j < index; j++) {
                if (students[j].getScore() > students[i].getScore()) {
                    Student temp = new Student();
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        //in part midanim ke avalin player score balatarin dard va midanim ke hamishe  yeck player brande bazi
        System.out.format("Max Score: %d%n", students[0].getScore());
        for (int k = 0; k < index; k++) {
            //in part  balatarin emtyaz migird(student) va  donbale tamam brande ha migarde
            if (students[0].getScore() == students[k].getScore()) {
                System.out.format("%s%n", students[k].getName());
            }
        }
    }
}

class Student {
    String name;//esm
    int kind;//term
    int score;//emtyazenu
    boolean in_game;
    first_guys f;
    second_guys s;
    king_bros k;
    int level = 0;// level makhsos player kebe har ozv enum n azir mishvad

    public int getLevel() {
        return level;
    }

    public boolean isIn_game() {
        return in_game;
    }

    public void setIn_game(boolean in_game) {
        this.in_game = in_game;
    }

    //in tabe level player afzayesh midahad
    public void setlevel(int j) {
        this.level = j;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKind() {
        return kind;
    }

    public void setKind(int kind) {
        this.kind = kind;
    }
}