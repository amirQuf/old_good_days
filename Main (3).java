import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LeagueManager l = new LeagueManager();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            LeagueManager.Team t = l.new Team();
            l.addTeams(t, sc.next());
        }
        while (sc.hasNext()) {
            int i = l.search(sc.next());
            int j = l.search(sc.next());
            int goal = sc.nextInt();
            int z_goal = sc.nextInt();
            l.getinfo(i, goal, z_goal);
            l.getinfo(j, z_goal, goal);
        }
        l.caculate();
        l.sort();
        LeagueManager.TableDrawer t = l.new TableDrawer();
        t.print(l.getTeams());
    }
}
class LeagueManager {
    class Team  {
        String name;
        int goal;
        int z_goal;
        int wins;
        int loses;
        int draw;
        int score;
        int GD;
        public void setName(String name) {
            this.name = name;
        }

        public void setGD() {
            this.GD = goal - z_goal;
        }

        public int getDraw() {
            return draw;
        }

        public int getScore() {
            return score;
        }

        public void setGoal(int goal) {
            this.goal += goal;
        }

        public void setZ_goal(int z_goal) {
            this.z_goal += z_goal;
        }

        public String getName() {
            return name;
        }

        public int getGoal() {
            return goal;
        }

        public int getZ_goal() {
            return z_goal;
        }

        public void setWins() {
            this.wins += 1;
        }

        public int getGD() {
            return GD;
        }

        public void setLoses() {
            this.loses += 1;
        }

        public void setDraw() {
            this.draw += 1;
        }

        public int getWins() {
            return wins;
        }

        public int getLoses() {
            return loses;
        }

        public void score() {
            score = wins * 4 + loses * 1 + draw * 2;
        }
    }

    Team[] teams = new Team[1000];
    int index = 0;

    public void addTeams(Team t, String name) {
        teams[index] = t;
        teams[index].setName(name);
        index++;
    }

    public int search(String name) {
        for (int i = 0; i < index; i++) {
            if (teams[i].name.equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public void getinfo(int i, int goal, int z_goal) {
        teams[i].setGoal(goal);
        teams[i].setZ_goal(z_goal);
        if (goal > z_goal) {
            teams[i].setWins();
        }
        if (goal < z_goal) {
            teams[i].setLoses();
        }
        if (goal == z_goal) {
            teams[i].setDraw();
        }
    }

    public Team[] getTeams() {
        return teams;
    }

    public void caculate() {
        for (int i = 0; i < index; i++) {
            teams[i].score();
            teams[i].setGD();
        }
    }

    public void sort() {
        for (int i = 0; i < index; i++){
            for (int j = i + 1; j < index  ; j++) {
                if (teams[i].getScore() < teams[j].getScore()) {
                    Team temp = new Team();
                    temp = teams[i];
                    teams[i] = teams[j];
                    teams[j] = temp;
                } else if (teams[i].getWins() < teams[j].getWins()) {
                    Team temp = new Team();
                    temp = teams[i];
                    teams[i] = teams[j];
                    teams[j] = temp;
                } else if (teams[i].getGoal() < teams[j].getGoal()) {
                    Team temp = new Team();
                    temp = teams[i];
                    teams[i] = teams[j];
                    teams[j] = temp;
                } else if (teams[i].getGD() < teams[j].getGD()) {
                    Team temp = new Team();
                    temp = teams[i];
                    teams[i] = teams[i];
                    teams[i] = temp;
                }else if(teams[j].getName().compareTo(teams[i].getName())>0){
                    Team temp = new Team();
                    temp = teams[i];
                    teams[i] = teams[i];
                    teams[i] = temp;
                }
            }
    }
        System.out.format("First Team: %s %n", teams[0].name);
        System.out.format("Last Team: %s %n", teams[index - 1].name);
    }

    class TableDrawer {
        public void print(Team[] teams) {
            String[] print = {"NAME", "WIN", "DRAW", "LOST", "GF", "GA", "GD", "SCORE"};
            System.out.format("%11s %3s %4s %4s %4s %4s %5s %5s%n", print[0], print[1], print[2], print[3]
                    , print[4], print[5], print[6], print[7]);
            for (int i = 0; i < index; i++) {
                System.out.format("%11s %3d %4d %4d %4d %4d %5d %5d%n"
                        , teams[i].getName(), teams[i].getWins(), teams[i].getDraw()
                        , teams[i].getLoses(), teams[i].getGoal(), teams[i].getZ_goal(), teams[i].getGD(), teams[i].getScore());
            }
        }
    }
}