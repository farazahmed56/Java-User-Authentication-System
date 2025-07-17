import java.util.Scanner;
import java.util.Random;


public class UserAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String savedUsername = "";
        String savedPassword = "";
        int choice;

        do {
            System.out.println("Press 1 to Sign Up");
            System.out.println("Press 2 to Login (if already have an account)");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {

                System.out.print("Enter Username: ");
                savedUsername = scanner.nextLine();

                System.out.print("Enter Password: ");
                savedPassword = scanner.nextLine();

                String confirmPassword;
                do {
                    System.out.print("Confirm Password: ");
                    confirmPassword = scanner.nextLine();
                    if (!confirmPassword.equals(savedPassword)) {
                        System.out.println("Passwords do not match. Please try again.");
                    }
                } while (!confirmPassword.equals(savedPassword));

                // CAPTCHA Verification
                Random rand = new Random();
                int captcha = rand.nextInt(9000) + 1000; // Generates a random 4-digit number
                System.out.println("CAPTCHA: " + captcha);
                System.out.print("Enter CAPTCHA: ");
                int enteredCaptcha = scanner.nextInt();

                if (enteredCaptcha == captcha) {
                    System.out.println("Registered Successfully! Now login.");
                } else {
                    System.out.println("CAPTCHA verification failed. Please sign up again.");
                    continue;
                }

            } else if (choice == 2) {
                // Login process
                System.out.print("Enter Username: ");
                String username = scanner.nextLine();

                System.out.print("Enter Password: ");
                String password = scanner.nextLine();

                if (username.equals(savedUsername) && password.equals(savedPassword)) {
                    System.out.println("Login Successful\nWelcome to Java World!");
                    break;
                } else {
                    System.out.println("Incorrect Username or Password. Please try again.");
                }
            } else {
                System.out.println("Invalid choice, please select 1 or 2.");
            }

        } while (true);
 
        scanner.close();
    }
}
