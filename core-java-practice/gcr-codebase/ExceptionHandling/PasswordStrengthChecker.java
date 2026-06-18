public class PasswordStrengthChecker {

    public static void checkPassword(String password) {

        try {

            // Check for null
            if (password == null) {
                throw new NullPointerException();
            }

            // Check for empty string
            if (password.isEmpty()) {
                System.out.println("Error: Password cannot be empty.");
                return;
            }

            // Length check
            if (password.length() < 8) {
                System.out.println("Error: Password must be at least 8 characters long.");
                return;
            }

            // First character uppercase
            if (!Character.isUpperCase(password.charAt(0))) {
                System.out.println("Error: First character must be uppercase.");
                return;
            }

            // Last character digit
            if (!Character.isDigit(password.charAt(password.length() - 1))) {
                System.out.println("Error: Last character must be a digit.");
                return;
            }

            // Special character check
            boolean hasSpecial = false;
            String specialChars = "@#$%&*";

            for (char ch : password.toCharArray()) {
                if (specialChars.indexOf(ch) != -1) {
                    hasSpecial = true;
                    break;
                }
            }

            if (!hasSpecial) {
                System.out.println("Error: Password must contain at least one special character (@,#,$,%,&,*).");
                return;
            }

            System.out.println("Password is Strong!");

        } catch (NullPointerException e) {
            System.out.println("Error: Password cannot be null.");
        } catch (Exception e) {
            System.out.println("Unexpected Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        checkPassword(null);
        checkPassword("");
        checkPassword("Abc@1");
        checkPassword("abcdef@1");
        checkPassword("Abcdefgh1");
        checkPassword("Abcdefgh@");
        checkPassword("Abcdefg@1");
    }
}