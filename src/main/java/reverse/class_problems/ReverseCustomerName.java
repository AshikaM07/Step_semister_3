package reverse.class_problems;

import java.util.Scanner;

public class ReverseCustomerName {

    public static String reverseCustomerName(String customerName) {

        StringBuilder reversed = new StringBuilder();

        for (int i = customerName.length() - 1; i >= 0; i--) {
            reversed.append(customerName.charAt(i));
        }

        return reversed.toString();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();

        String reversedName = reverseCustomerName(customerName);

        System.out.println();
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);

        scanner.close();
    }
}