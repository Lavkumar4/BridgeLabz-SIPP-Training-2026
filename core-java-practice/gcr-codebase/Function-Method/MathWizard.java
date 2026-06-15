public class MathWizard {
    // Instance Variable
    int instanceVar = 100;

    // Prime Number syntax
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Factorial condititon
    public long factorial(int n) {
        long fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    // Overloaded Factorial (double) condition
    public double factorial(double n) {
        double fact = 1;

        for (int i = 1; i <= (int) n; i++) {
            fact *= i;
        }

        return fact;
    }

    // Fibonacci Series nth term
    public void fibonacci(int n) {
        int first = 0, second = 1;

        System.out.print("Fibonacci Series: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println();
    }

    // GCD algorithm condition
    public int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    // LCM condition
    public int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    // Power Function condition
    public long power(int base, int exp) {
        long result = 1;

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    //Local and Instance Variables condition
    public void showScope() {

        // Local Variable
        int localVar = 50;

        System.out.println("Local Variable = " + localVar);
        System.out.println("Instance Variable = " + instanceVar);
    }

    public static void main(String[] args) {

        MathWizard wizard = new MathWizard();

        System.out.println("Is 17 Prime? " + wizard.isPrime(17));

        System.out.println("Factorial of 5 = "
                + wizard.factorial(5));

        System.out.println("Factorial of 6.0 = "
                + wizard.factorial(6.0));

        wizard.fibonacci(10);

        System.out.println("GCD of 24 and 36 = "
                + wizard.gcd(24, 36));

        System.out.println("LCM of 24 and 36 = "
                + wizard.lcm(24, 36));

        System.out.println("2^5 = "
                + wizard.power(2, 5));

        wizard.showScope();
    }
}