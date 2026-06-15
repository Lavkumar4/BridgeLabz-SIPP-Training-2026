import java.util.Scanner;

public class UniqueFrequency {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String str = sc.nextLine();

        for(int i=0;i<str.length();i++) {

            boolean visited = false;

            for(int j=0;j<i;j++) {
                if(str.charAt(i)==str.charAt(j)) {
                    visited = true;
                    break;
                }
            }

            if(!visited) {

                int count = 0;

                for(int k=0;k<str.length();k++) {
                    if(str.charAt(i)==str.charAt(k))
                        count++;
                }

                System.out.println(str.charAt(i)+" -> "+count);
            }
        }
    }
}