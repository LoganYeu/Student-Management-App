import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentManager {
    private ArrayList<Student> studentDatabase;
    private ArrayList<String> coursesList;
    private final String CONSOLE_PASSWORD;

    public StudentManager() {
        CONSOLE_PASSWORD = "New World";
        studentDatabase = new ArrayList<Student>();

        coursesList = new ArrayList<String>();
        coursesList.add("History 101");
        coursesList.add("Mathematics 101");
        coursesList.add("English 101");
        coursesList.add("Chemistry 101");
        coursesList.add("Computer Science 101");


    }

    /**
     * Runs the student manager program.
     */
    public void runStudentManager() {
        Scanner userInput = new Scanner(System.in);
        boolean running = true;

        while(running) {
            int modeSelection = initialMenu(userInput);

            switch (modeSelection) {
                case 1:
                    administratorMode(userInput);
                break;

                case 2:
                    System.out.println("FUCK");
                break;

                default:
                    System.out.println("We are not sure what happened, please try again.");
            }

            //asks user if they would like to run the program again or quit it.
            int askAgain = useAppAgain(userInput);
            if(askAgain == 1) {
                System.out.println("Okay taking you back to the main menu. ");
            }
            else {
                running = false;
            }

        }

    }

    /**
     * prints the initial menu of the program and returns the answer to be used in runStudentManager's switch case.
     *
     * @param userInput
     * @return
     */
    public int initialMenu(Scanner userInput) {
        System.out.println("Press 1 to log in as administrator");
        System.out.println("Press 2 to log in as a student");

        boolean lookingForMenuAnswer = true;
        while(lookingForMenuAnswer) {
            try{
                int initialMenuAnswer = userInput.nextInt();
                if(initialMenuAnswer == 1 || initialMenuAnswer == 2) {
                    return initialMenuAnswer;
                }
                else {
                    System.out.println("The only valid choices are 1 or 2, please try again.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("The only valid choices are 1 or 2, please try again.");
                userInput.nextLine();
            }
        }
        return 0;
    }

    public int useAppAgain(Scanner userInput) {
        boolean validResponse = false;
        while(!validResponse) {
            try {
                System.out.println("Press 1 to use the application again, otherwise press 2 to quit. ");

                int againAnswer = userInput.nextInt();
                if (againAnswer == 1 || againAnswer == 2) {
                    return againAnswer;
                }
                else {
                    System.out.println("The only valid choices are 1 or 2, please try again. ");
                }
            }
            catch (InputMismatchException e) {
                System.out.println("The only valid choices are 1 or 2, please try again. ");
                userInput.next();
            }
        }
        return 0;
    }

    /**
     * Runs the administrator mode of the program where the user can add a student to database or view information on a student.
     *
     * @param userInput
     */
    public void administratorMode(Scanner userInput) {
        boolean adminMode = true;
        userInput.nextLine();

        while(adminMode) {
            System.out.println("Please enter the administrator password: ");
            String answer = userInput.nextLine();
            if(answer.equals(CONSOLE_PASSWORD)) {
                System.out.println("Access Granted!");
                //Admin mode menu.
                System.out.println("Press 1 to add a student to the database");

                int adminMenu = userInput.nextInt();

                switch (adminMenu) {
                    case 1:
                        createNewStudents(userInput);
                        adminMode = false;
                        break;
                }
            }
            else {
                System.out.println("Password incorrect, please try again.");
                adminMode = false;
            }



        }
    }

    /**
     * Used by the administratorMode method to create a new student and add it to the "database" arrayList for students.
     *
     * @param userInput
     */
    public void createNewStudents(Scanner userInput) {
        System.out.println("How many students would you like to add to the database?");
        int numOfStudents = userInput.nextInt();


        for(int i = 1; i <= numOfStudents; i++) {
            System.out.println("What is student number " + i + "'s name?");
            userInput.nextLine();
            String currentStudentName = userInput.nextLine();

            boolean lookingForYear = true;
            int yearAnswer = 0;

            while(lookingForYear) {
                System.out.println("What is student " + currentStudentName + "'s grade level 1-4?");
                try {
                    yearAnswer = userInput.nextInt();
                    System.out.println(yearAnswer);
                    if(yearAnswer == 1 || yearAnswer == 2 || yearAnswer == 3 || yearAnswer == 4) {
                        lookingForYear = false;
                    }
                    else {
                        System.out.println("The only valid grade levels are 1-4, please try again.");
                        userInput.nextLine();
                    }
                }
                catch (InputMismatchException e) {
                    System.out.println("The only valid grade levels are 1-4, please try again.");
                    userInput.nextLine();
                }
            }

            //Generate random id for student if year validation is successful.

        }
    }


}
