/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcpartb;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author hp
 */
public class JcPartB {

    static Scanner input = new Scanner(System.in);
    static DeliveryMan newDeliveryMan = new DeliveryMan();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cont;

        do {
            createNewDeliveryMan();

            System.out.println(newDeliveryMan);

            System.out.println("Continue?(Y/N)");

            cont = input.nextLine();

        } while (cont.equals("y"));

    }
    //do tittle
    // ic validation
    //do automate calculate date to age

    public static void createNewDeliveryMan()   {
        String name;
        String type = "";
        String sel;
        String IC;
        CharSequence inputStr;
        Pattern pattern ;
        Matcher matcher ;
        System.out.println("New Deliveryman Registration\n");
//        System.out.println("Dob");
//        String dob=input.nextLine();
        try {
            String target = "19/8/2007";
            DateFormat df = new SimpleDateFormat("dd/mm/yy");
            Date result =  df.parse(target);
            System.out.println(result); 
        } catch (ParseException pe) {
            pe.printStackTrace();
        }
    
        
        do{
        System.out.print("Enter new name: ");
        name = input.nextLine();
        inputStr=name;
        
        pattern=Pattern.compile(new String("^[a-zA-Z\\s]*$"));
        matcher=pattern.matcher(inputStr);
            if (!matcher.matches()) {
                System.out.println("Invalid name\n");
                

            }
        } while (!matcher.matches());

        boolean icVerify;
        do {
            icVerify = true;
            System.out.print("\nEnter IC (no hyphen): ");
            IC = input.nextLine();
            for (int i = 0; i < IC.length(); i++) {
                if (Character.isDigit(IC.charAt(i)) == false) {
                    icVerify = false;
                }
            }

            if (icVerify == false) {
                System.out.println("Invalid IC entered!  Please enter digits only.");
            } else if (IC.length() != 12) {
                System.out.println("Invalid IC entered! PLease enter 12 digits.");
                icVerify = false;
            }
        } while (icVerify == false);

        int age = 0;
        do {

            System.out.print("\nEnter age: ");
            age = input.nextInt();
            input.nextLine();
            if (age < 17 || age > 60) {
                System.out.println("Please enter again! The age must be between 18 and 60");

            }
        } while ((age < 17 || age > 60));

        do {
            System.out.println("\nSelect the type\n 1)Full time\n 2)Part Time");
            sel = input.nextLine();
            if (sel.equals("1")) {
                type = "Full time";
            } else if (sel.equals("2")) {
                type = "Part time";
            } else {
                type = "Invalid input";
                System.out.println("Invalid input");
            }
        } while (type.equals("Invalid input"));
        newDeliveryMan = new DeliveryMan(name, IC, age, type);
        System.out.println("The new Deliveryman, " + name + " " + IC + " is added .");

    }

    private static boolean Date(String dob) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   public static int getAge(Date dateOfBirth) {
    Calendar today = Calendar.getInstance();
    Calendar birthDate = Calendar.getInstance();
    birthDate.setTime(dateOfBirth);
    if (birthDate.after(today)) {
        throw new IllegalArgumentException("You don't exist yet");
    }
    int todayYear = today.get(Calendar.YEAR);
    int birthDateYear = birthDate.get(Calendar.YEAR);
    int todayDayOfYear = today.get(Calendar.DAY_OF_YEAR);
    int birthDateDayOfYear = birthDate.get(Calendar.DAY_OF_YEAR);
    int todayMonth = today.get(Calendar.MONTH);
    int birthDateMonth = birthDate.get(Calendar.MONTH);
    int todayDayOfMonth = today.get(Calendar.DAY_OF_MONTH);
    int birthDateDayOfMonth = birthDate.get(Calendar.DAY_OF_MONTH);
    int age = todayYear - birthDateYear;

    // If birth date is greater than todays date (after 2 days adjustment of leap year) then decrement age one year
    if ((birthDateDayOfYear - todayDayOfYear > 3) || (birthDateMonth > todayMonth)){
        age--;
    
    // If birth date and todays date are of same month and birth day of month is greater than todays day of month then decrement age
    } else if ((birthDateMonth == todayMonth) && (birthDateDayOfMonth > todayDayOfMonth)){
        age--;
    }
    return age;
}


}
