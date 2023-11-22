package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("welcome!");
        System.out.println("please enter package weight: ");
        int weight = scanner.nextInt();

        Package userPackage = new Package(weight);

        while (true) {
            System.out.println("enter shipping method (1 for standard and 2 for express):");
            int answer = scanner.nextInt();

            if (answer == 1) {
                StandardShip standardShip = new StandardShip(userPackage);
                userPackage.setShippingMethod(standardShip);
            } else if (answer == 2) {
                ExpressShip expressShip = new ExpressShip(userPackage);
                userPackage.setShippingMethod(expressShip);
            }

            System.out.println(userPackage.getShippingMethod().toString());

            System.out.println("should package be delivered (1 for yes and 0 for no):");
            answer = scanner.nextInt();

            if (answer == 1) {
                userPackage.sendPackage();
                break;
            }

            System.out.println(userPackage.getState().toString());
        }

        System.out.println(userPackage.getState().toString());
    }
}