Assessment 1 Plan - capsule hotel booking manager

1. Specifications
    - Allows admin to set the hotel's capacity
    - Allows booking of an unoccupied capsule
    - Allows admin to check out a guest
    - Allows admin to view capsule numbers and guests in groups of 11 (5 previous rooms, room, and next 5 rooms)

2. States to be tracked
    - int capacity
    - String[] capsules = new String[capacity]

3. Steps
    01. Print welcome screen
    02. Prompt for capacity
    03. Print available capacity
    04. Print Menu
    05. Prompt user for menu option
    06. Execute user input (1. Check In, 2. Check Out, 3. View Guests, 4. Exit)
    07. Repeat until user decides to exit
    08. Print exit message when user decides to end program
    09. Verify that user really does want to exit the program
    10. End program

4. Methods
    - public static void startUp() - prints welcome screen
    - public static int getCapacity(int capacity) - get input from user, loop until valid input is received
    - public static int displayMainMenu() - display menu options and wait for user input, loop until valid input is       received
    - public static void checkIn() - prompt user for 1. guest's name, 2. capsule #, validate guest's name and verify capsule is available and/or in range of capacity
    - public static void checkOut() - prompt user for capsule number, verifying that the capsule is not already unoccupied and/or in range of capacity
    - public static void viewGuests() - prompt user for capsule number, display (if able) 5 previous capsule numbers, given capsule number (if able), and next 5 capsule numbers (if able).
    - public static void exit() - validate user really does want to end program, loop until valid input is entered if yes print goodbye and end program, if no go to main menu.