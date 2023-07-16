package controller;

import java.util.Scanner;

public class Amount {
    private Scanner scanner;

    public Amount() {
        scanner = new Scanner(System.in);
    }

    public int readAmount() {
        System.out.println("Enter the amount:");
        return scanner.nextInt();
    }
}