import java.util.Scanner;

public class CapsuleHotelManager {

    public static int capacity = 0;

    public static String[] capsules;

    public static void main(String[] args){

        startUp();
        capacity = getCapacity();
        capsules = new String[capacity];
        for(int i = 0; i < capacity; i++){
            capsules[i] = "[unoccupied]";
        }
        displayMainMenu();

    }

    public static void startUp(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        System.out.println("  Welcome to the Capsule-Hotel Manager  ");
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
    }

    public static int getCapacity(){
        Scanner console = new Scanner(System.in);

        boolean valid = false;
        int capacity = 0;
        do{
            System.out.print("Enter the number of capsules available: ");

            try {
                capacity = Integer.parseInt(console.nextLine());
            } catch (Exception e){
                System.out.println("Sorry, that's not a valid option");
                continue;
            }

            if(capacity == 0){
                System.out.println("Sorry, there should be more than 0 capsules");
            }else if(capacity < 0){
                System.out.println("Sorry, there can't be negative capsules");
            }else{
                valid = true;
            }
        } while(!valid);

        System.out.println("There are "+ capacity + " unoccupied capsules ready to be booked");

        return capacity;
    }

    public static void checkIn() {

        Scanner console = new Scanner(System.in);
        String name;
        int capsule = 0;
        boolean validName = false;
        boolean validCapsule = false;
        String input = "";


        System.out.println("++++++++++++++++");
        System.out.println(" Guest Check In ");
        System.out.println("++++++++++++++++");

        do {
            System.out.print("Guest Name: ");
            name = console.nextLine();

            if(name.equals("[unoccupied]")){
                System.out.println("Sorry, that name is invalid, try again");
            }else {
                validName = true;
            }
        }while(!validName);

        do {
            System.out.println("Enter a capsule number or enter \"quit\" to stop");
            System.out.print("Capsule #[1-" + capacity + "]: ");
            input = console.nextLine();

            if(input.equalsIgnoreCase("quit")){
                break;
            }else {
                try {
                    capsule = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Sorry, that's not an option");
                    continue;
                }

                if (capsule != 0 && capsule <= capacity) {
                    if (capsules[capsule - 1].equals("[unoccupied]")) {
                        validCapsule = true;
                    } else {
                        System.out.println("Error: Capsule #" + capsule + " is occupied");
                    }
                } else {
                    System.out.println("The capsule you entered is not between [1-" + capacity + "]");
                }
            }
        }while(!validCapsule);

        if(input.equalsIgnoreCase("quit")){
            System.out.println("Going back to main menu");
        }else {
            capsules[capsule - 1] = name;
            System.out.println("Success!");
            System.out.println(name + " is now occupying capsule " + capsule);
        }
        clearScreen();
    }

    public static void checkOut() {

        Scanner console = new Scanner(System.in);
        int capsuleNum = 0;
        boolean validCapsule = false;
        String input = "";

        System.out.println("+++++++++++++++++");
        System.out.println(" Guest Check Out ");
        System.out.println("+++++++++++++++++");
        do {
            System.out.println("Enter a capsule number or enter \"quit\" to stop");
            System.out.print("Capsule #[1-" + capacity + "]: ");
            input = console.nextLine();

            if(input.equalsIgnoreCase("quit")){
                break;
            }else {
                try {
                    capsuleNum = Integer.parseInt(input);
                } catch (Exception e) {
                    System.out.println("Sorry, that's not an option");
                    continue;
                }
                if (capsuleNum == 0 || capsuleNum > capacity) {
                    System.out.println("Sorry, that's not an option");
                } else if (capsules[capsuleNum - 1].equals("[unoccupied]")) {
                    System.out.println("Error: Capsule #" + capsuleNum + " is unoccupied");
                } else {
                    validCapsule = true;
                }
            }
        }while(!validCapsule);

        if(input.equalsIgnoreCase("quit")){
            System.out.println("Going back to main menu");
        }else {
            System.out.println("Success!");
            System.out.println(capsules[capsuleNum - 1] + " checked out from capsule #" + capsuleNum);
            capsules[capsuleNum - 1] = "[unoccupied]";
        }
        clearScreen();
    }

    public static void viewGuests() {

        Scanner console = new Scanner(System.in);
        int capsuleNum = 0;
        boolean validCapsule = false;

        System.out.println("+++++++++++++++++");
        System.out.println("   View Guests   ");
        System.out.println("+++++++++++++++++");

        do {
            System.out.print("Capsule #[1-" + capacity + "]: ");
            try {
                capsuleNum = Integer.parseInt(console.nextLine());
            }catch(Exception e){
                System.out.println("Sorry, that's not an option");
            }
            System.out.println();
            System.out.println();
            if (capsuleNum == 0 || capsuleNum > capacity) {
                System.out.println("Sorry, that's not an option");
            } else {
                validCapsule = true;
            }
        } while (!validCapsule);

        System.out.println("Capsule: Guest");

        if (capsuleNum <= 5 && (capsules.length - capsuleNum) <= 5) {
            //if the number is less than 5 and it does not have 5 numbers after it

            for (int i = 0; i < capsuleNum; i++){
                if(i == capsuleNum -1) {
                    System.out.print("->");
                }
                System.out.print((i + 1) + ": " + capsules[i]);
                if(i == capsuleNum -1) {
                    System.out.print("<-");
                }
                System.out.println();
            }
            for (int i = capsuleNum; i < capsuleNum + (capsules.length - capsuleNum); i++){
                System.out.println((i + 1) + ": " + capsules[i]);
            }
            clearScreen();
        } else if (capsuleNum <= 5) {
            //if the number is lower than 5 and has 5 numbers after it

            for(int i = 0; i < capsuleNum; i++){
                if(i == capsuleNum -1) {
                    System.out.print("->");
                }
                System.out.print((i + 1) + ": " + capsules[i]);
                if(i == capsuleNum -1) {
                    System.out.print("<-");
                }
                System.out.println();
            }
            //print all 5 capsules after capsuleNum
            for(int i = capsuleNum; i < capsuleNum + 5; i++){
                System.out.println((i + 1) + ": " + capsules[i]);
            }
            clearScreen();
        } else if ((capsules.length - capsuleNum) < 5) {
            //if the number is greater than 5 but does not have 5 numbers after it
            //print all 5 capsules before capsuleNum
            for(int i = capsuleNum - 5; i < capsuleNum; i++){
                if(i == capsuleNum -1) {
                    System.out.print("->");
                }
                System.out.print((i + 1) + ": " + capsules[i]);
                if(i == capsuleNum -1) {
                    System.out.print("<-");
                }
                System.out.println();
            }
            //print all capsules after capsuleNum, if any
            for(int i = capsuleNum; i < (capsules.length - capsuleNum) + capsuleNum; i++){
                System.out.println((i + 1) + ": " + capsules[i]);
            }
            clearScreen();
        } else {
            //any other case where there are 5 or numbers before and 5 or more after
            for (int i = capsuleNum - 6; i < capsuleNum + 5; i++){
                System.out.println((i + 1) + ": " + capsules[i]);
            }
            clearScreen();
        }
    }

    public static void exit() {

        Scanner console = new Scanner(System.in);
        boolean done = false;

        do {
            System.out.println("++++++");
            System.out.println(" Exit ");
            System.out.println("++++++");
            System.out.println("Are you sure you want to exit?");
            System.out.println("All data will be lost.");
            System.out.print("Exit [y/n]: ");
            char res = Character.toLowerCase(console.nextLine().charAt(0));

            switch (res) {
                case 'y':
                    System.out.println("Goodbye!");
                    System.exit(0);
                case 'n':
                    done = true;
                    break;
                default:
                    System.out.println("Sorry, that's not an option");
                    break;
            }
        }while(!done);

    }

    public static void displayMainMenu() {
        Scanner console = new Scanner(System.in);

        int choice = 0;
        do{
            System.out.println("++++++++++++++++++++++++");
            System.out.println("+      Guest Menu      +");
            System.out.println("++++++++++++++++++++++++");
            System.out.println("+ 1 - Check In         +");
            System.out.println("+ 2 - Check Out        +");
            System.out.println("+ 3 - View Guests      +");
            System.out.println("+ 4 - Exit             +");
            System.out.println("++++++++++++++++++++++++");
            System.out.print("Choose an option [1-4]: ");

            try{
                choice = Integer.parseInt(console.nextLine());
            }catch (Exception e){
                System.out.println("Sorry, that's not an option");
                continue;
            }

            switch (choice) {
                case 1 :
                    checkIn();
                    break;
                case 2 :
                    checkOut();
                    break;
                case 3 :
                    viewGuests();
                    break;
                case 4 :
                    exit();
                    break;
                default :
                    System.out.println("Sorry, that's not an option");
                    break;
            }
        }while(true);

    }

    public static void clearScreen() {
        Scanner console = new Scanner(System.in);
        System.out.print("Press enter to continue: ");
        console.nextLine();

        for(int i = 0; i < 10; i++){
            System.out.println();
        }
    }
}
