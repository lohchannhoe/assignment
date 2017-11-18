package affiliate;

import java.util.Scanner;

public class Affiliate {

    static boolean numberOrNot(String tel) {
        try {
            Integer.parseInt(tel);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        String name;
        String owner;
        String tel;
        String email;
        String password;
        String description;
        String confirm_password;
        String location;

        String str1 = "KENNY ROGER";
        String str2 = "KFC";
        String str3 = "MCD";
        String str4 = "COCO CAFE";

        System.out.println("Welcome to the Fastest Deliveryman !");
        System.out.println("************************************");
        System.out.println("");
        System.out.println("Registration");
        System.out.println("------------");

        Scanner scan = new Scanner(System.in);

        System.out.print("Restaurant Name  : ");
        name = scan.nextLine();
        String rname = name.toUpperCase();
        System.out.println();

        System.out.print("Restaurant Owner : ");
        owner = scan.nextLine();
        System.out.println();

        System.out.print("Password         : ");
        password = scan.nextLine();
        System.out.println();
        System.out.print("Confirm password : ");
        confirm_password = scan.nextLine();
        System.out.println();

        System.out.print("Description      : ");
        description = scan.nextLine();
        System.out.println();

        System.out.print("Telephone        : ");
        tel = scan.nextLine();
        System.out.println();

        System.out.print("E-mail Address   : ");
        email = scan.nextLine();
        System.out.println("");

        System.out.print("Location         : ");
        location = scan.nextLine();

        if (password.equals(confirm_password)) {
            System.out.println("");
            if (Affiliate.numberOrNot(tel) && (tel.length() == 10)) {
                if (rname.equals(str1)) {
                    System.out.println("\nDuplicate Restaurant Name");
                } else if (rname.equals(str2)) {
                    System.out.println("\nDuplicate Restaurant Name");
                } else if (rname.equals(str3)) {
                    System.out.println("\nDuplicate Restaurant Name");
                } else if (rname.equals(str4)) {
                    System.out.println("\nDuplicate Restaurant Name");
                } else {
                    System.out.println("Register Successfully!");
                    System.out.println("Restaurant Name\t\t: " + rname);
                    System.out.println("Restaurant Owner\t: " + owner);
                    System.out.println("Description\t\t: " + description);
                    System.out.println("Telephone\t\t: " + tel);
                    System.out.println("Email\t\t\t: " + email);
                    System.out.println("Location\t\t: " + location);
                }
            } else {
                System.out.println("\nInvalid Telephone.");
            }
        } else {
            System.out.println("\nInvalid Password");

        }
    }
}
