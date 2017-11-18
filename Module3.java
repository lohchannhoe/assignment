package module.pkg3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("");

        Restaurant restaurant1 = new Restaurant("Indocafe", "1001", "011234518", "Jalan KL");
        Restaurant restaurant2 = new Restaurant("Supercafe", "1002", "011234518", "Jalan KL");
        Restaurant restaurant3 = new Restaurant("Ayamcafe", "1003", "011234518", "Jalan KL");

        boolean continueOrder = false;
        do {
            System.out.println("\nPlease select a restaurant\n");
            System.out.println("1: " + restaurant1.getName());
            System.out.println("2: " + restaurant2.getName());
            System.out.println("3: " + restaurant3.getName());
            System.out.println("Q: Quit");

            Scanner scn = new Scanner(System.in);
            System.out.print("Selection: ");
            int selection = scn.next().charAt(0);

            do {
                System.out.println("");
                switch (selection) {

                    case '1':
                        System.out.println("\nIndocafe Menu");
                        System.out.println("=============================================");
                        System.out.println(rightPadding("No. ", 5) + rightPadding("Item", 30)
                                + priceJustified("Price", 10));
                        System.out.println(rightPadding("1. ", 5) + rightPadding("Fried Chicken", 30)
                                + priceJustified("3.00", 10));
                        System.out.println(rightPadding("2. ", 5) + rightPadding("Nugget", 30)
                                + priceJustified("0.50", 10));
                        System.out.println(rightPadding("3. ", 5) + rightPadding("Ice Cream", 30)
                                + priceJustified("1.00", 10));
                        continueOrder = true;
                        break;

                    case '2':
                        System.out.println("\nSupercafe Menu");
                        System.out.println("=============================================");
                        System.out.println(rightPadding("No. ", 5) + rightPadding("Item", 30)
                                + priceJustified("Price", 10));
                        System.out.println(rightPadding("1. ", 5) + rightPadding("T-bone Steak", 30)
                                + priceJustified("35.00", 10));
                        System.out.println(rightPadding("2. ", 5) + rightPadding("Atlantic Lobster", 30)
                                + priceJustified("70.00", 10));
                        System.out.println(rightPadding("3. ", 5) + rightPadding("Seafood Platter", 30)
                                + priceJustified("200.00", 10));
                        continueOrder = true;
                        break;

                    case '3':
                        System.out.println("\nAyamcafe Menu");
                        System.out.println("=============================================");
                        System.out.println(rightPadding("No. ", 5) + rightPadding("Item", 30)
                                + priceJustified("Price", 10));
                        System.out.println(rightPadding("1. ", 5) + rightPadding("Super Ayam Set 1", 30)
                                + priceJustified("35.00", 10));
                        System.out.println(rightPadding("2. ", 5) + rightPadding("Suuper Ayam Set 2", 30)
                                + priceJustified("70.00", 10));
                        System.out.println(rightPadding("3. ", 5) + rightPadding("Ultimate Ayam Set", 30)
                                + priceJustified("200.00", 10));
                        continueOrder = true;
                        break;

                    case 'Q':
                        System.exit(0);
                    case 'q':
                        System.exit(0);

                    default:
                        System.out.println("Invalid selection! Please try again.");
                        continueOrder = false;
                        break;

                }
                int i = 0;
                if (continueOrder == true) {
                    i++;
                    System.out.print("\nSelect an item: ");
                    int menuSelection = scn.nextInt();
                    System.out.print("Select quantity: ");
                    int quantity = scn.nextInt();
                    System.out.println("Added " + quantity + " Item" + menuSelection + " into the cart.");
//                    ArrayList orderList = new ArrayList(); 
//                    orderList.add(i,"" + menuSelection + quantity);

                    boolean checkout;
                    do {

                        checkout = true;
                        System.out.println("Continue order or check out?");
                        System.out.println("1: Continue     2: Check out");
                        int option = scn.nextInt();
                        if (option == 1) {
                            continueOrder = true;
                        } else if (option == 2) {
                            System.out.println("Your order will be delivered shortly. Thank you for choosing Fastest Deliveryman. ");
                            continueOrder = false;
                            break;
                        } else {
                            System.out.println("Invalid input! Please try again.");
                            checkout = false;
                        }
                    } while (checkout == false);
                }

            } while (continueOrder == true);
            continueOrder = true;
        } while (continueOrder == false);
    }

    public static String rightPadding(String str, int num) {
        return String.format("%1$-" + num + "s", str);
    }

    public static String priceJustified(String str, int num) {
        return String.format("%" + num + "s", str);
    }
}
