import java.util.Scanner;

public class FivePersonNumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter number for player " + i + " >> ");
            numbers[i-1] = input.nextInt();
        }
        for (int i = 0; i < numbers.length; i++) {
            String asterisks = "";
            for (int j = 0; j < numbers[i]; j++) {
                asterisks += "*";
            }
            System.out.println("Player " + (i+1) + ": " + asterisks);
        }
    }
}