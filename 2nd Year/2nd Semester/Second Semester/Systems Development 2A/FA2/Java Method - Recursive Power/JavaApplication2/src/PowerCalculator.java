public class PowerCalculator {

    public static void main(String[] args) {
        // Test the method with some examples
        System.out.println(recursivePower(2, 3));   // Output: 8
        System.out.println(recursivePower(2, -3));  // Output: 0.125
        System.out.println(recursivePower(5, 0));   // Output: 1
        System.out.println(recursivePower(3, -2));  // Output: 0.1111111111111111
    }

    public static double recursivePower(int base, int exponent) {
        // Base case: when exponent is 0
        if (exponent == 0) {
            return 1;
        }
        // Handle negative exponent
        else if (exponent < 0) {
            return 1.0 / recursivePower(base, -exponent);
        } 
        // Recursive case for positive exponent
        else {
            return base * recursivePower(base, exponent - 1);
        }
    }
}