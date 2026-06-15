import java.util.Scanner;

public class RockPaperScissors {

    static String computerChoice() {

        int n = (int)(Math.random()*3);

        if(n==0) return "rock";
        if(n==1) return "paper";

        return "scissors";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int userWin = 0;
        int compWin = 0;

        System.out.print("Enter Number of Games: ");
        int games = sc.nextInt();

        for(int i=1;i<=games;i++) {

            System.out.print("rock/paper/scissors: ");
            String user = sc.next();

            String comp = computerChoice();

            System.out.println("Computer = " + comp);

            if(user.equals(comp))
                System.out.println("Draw");

            else if(
                    (user.equals("rock") && comp.equals("scissors")) ||
                    (user.equals("paper") && comp.equals("rock")) ||
                    (user.equals("scissors") && comp.equals("paper"))
                   ) {
                userWin++;
                System.out.println("User Wins");
            }
            else {
                compWin++;
                System.out.println("Computer Wins");
            }
        }

        System.out.println("\nUser Wins = " + userWin);
        System.out.println("Computer Wins = " + compWin);

        double userPercent = (userWin * 100.0) / games;
        double compPercent = (compWin * 100.0) / games;

        System.out.println("User % = " + userPercent);
        System.out.println("Computer % = " + compPercent);
    }
}