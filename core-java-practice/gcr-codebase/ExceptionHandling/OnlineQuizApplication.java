public class OnlineQuizApplication {

    public static void main(String[] args) {

        String[] answers = {"A", "B", "C", "D"};

        int[] indicesToCheck = {0, 1, 2, 5, 3};

        for (int index : indicesToCheck) {

            try {
                if (answers[index].equals("A")) {
                    System.out.println("Index " + index + ": Correct Answer");
                } else {
                    System.out.println("Index " + index + ": Incorrect Answer");
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + index + ": Invalid answer position.");

            } catch (NullPointerException e) {
                System.out.println("Index " + index + ": Answer is missing.");
            }
        }

        System.out.println("Quiz evaluation completed.");
    }
}