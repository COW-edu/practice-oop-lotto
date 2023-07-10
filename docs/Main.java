package Lotto;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Console console = new Console();
        console.run(scanner);
        scanner.close();
    }
}