package gcr-codebase.string.Level2;

public import java.util.Scanner;

public class VotingCheck {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] age = new int[10];

        for(int i=0;i<10;i++) {
            System.out.print("Enter Age: ");
            age[i] = sc.nextInt();
        }

        System.out.println("Age\tCan Vote");

        for(int i=0;i<10;i++) {

            if(age[i] >= 18)
                System.out.println(age[i] + "\tTrue");
            else
                System.out.println(age[i] + "\tFalse");
        }
    }
} {
    
}
