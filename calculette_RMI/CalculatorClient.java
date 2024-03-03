import java.rmi.*;
import java.util.Scanner;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            Calculator calculator = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            while (true) {
                System.out.println("Choose operation:");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                System.out.println("5. Exit");
                System.out.print("Enter operation code: ");
                int choice = scanner.nextInt();
                
                if (choice == 5) {
                    break;
                }

                System.out.print("Enter first operand: ");
                double x = scanner.nextDouble();
                System.out.print("Enter second operand: ");
                double y = scanner.nextDouble();

                double result = 0;

                switch (choice) {
                    case 1:
                        result = calculator.add(x, y);
                        break;
                    case 2:
                        result = calculator.subtract(x, y);
                        break;
                    case 3:
                        result = calculator.multiply(x, y);
                        break;
                    case 4:
                        result = calculator.divide(x, y);
                        break;
                    default:
                        System.out.println("Invalid choice");
                }

                System.out.println("Result: " + result);
            }
        } catch (Exception e) {
            System.err.println("CalculatorClient exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
