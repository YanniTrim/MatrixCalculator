import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner inputer = new Scanner(System.in);

        Matrix m1 = Matrix.framer();

        boolean doneConstructing = false;
        while (!doneConstructing) {
            System.out.println("Another Matrix? (Y or N)");
            String answer = inputer.nextLine();
            if (answer.equals("Y")) {
                System.out.println("Matrix 2:");
                Matrix m2 = Matrix.framer();
                Operations.add(m1, m2);
                doneConstructing = true;
            } else if (answer.equals("N")) {
                doneConstructing = true;
            } else {
                System.out.println("Invalid Input - Try Again");
                continue;
            }
        }

        m1.transpose();


    }
}