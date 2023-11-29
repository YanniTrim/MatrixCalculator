import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner inputer = new Scanner(System.in);

        Matrix m1 = Matrix.builder();

        boolean doneConstructing = false;
        while (!doneConstructing) {
            System.out.println("Another Matrix? (Y or N)");
            String answer = inputer.nextLine();
            if (answer.equals("Y")) {
                System.out.println("Matrix 2:");
                Matrix m2 = Matrix.builder();

                boolean doneOperating = false;
                while (!doneOperating) {
                    System.out.println("What Operation? (Add, Subtract, Multiply or DONE)");
                    String newAnswer = inputer.nextLine();
                    if (newAnswer.equals("Add")) {
                        m1.add(m2);
                    } else if (newAnswer.equals("Subtract")) {
                        m1.subtract(m2);
                    } else if (newAnswer.equals("DONE")) {
                        doneOperating = true;
                    } else if (newAnswer.equals("Multiply")) {
                        m1.multiply(m2);
                    }
                }
                doneConstructing = true;
            } else if (answer.equals("N")) {
                doneConstructing = true;
            } else {
                System.out.println("Invalid Input - Try Again");
                continue;
            }
        }



    }
}