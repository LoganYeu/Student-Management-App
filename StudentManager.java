import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Random;

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
                    studentMode(userInput);
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
                System.out.println("Press 2 to search for information on a student or students.");

                int adminMenu = userInput.nextInt();

                switch (adminMenu) {
                    case 1:
                        createNewStudents(userInput);
                        adminMode = false;
                        break;
                    case 2:
                        showStudentInfo(userInput);
                        adminMode = false;
                        break;

                    default: System.out.println("Something went wrong, please try again.");
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
            String ID = generateStudentID(yearAnswer).toString();

            Student createdStudent = new Student(currentStudentName, yearAnswer, ID);
            studentDatabase.add(createdStudent);
            System.out.println("Student added");
            System.out.println("Name: " + currentStudentName + " Year: " + yearAnswer + " ID: " + ID);

        }
    }

    public void showStudentInfo(Scanner userInput) {
        boolean lookingForAnswer = true;
        int answer = 0;
        System.out.println("Press 1 to show info of student by ID number.");
        System.out.println("Press 2 to show all students in database.");

        while(lookingForAnswer) {
            try {
                answer = userInput.nextInt();
                lookingForAnswer = false;
            } catch (InputMismatchException e) {
                System.out.println("The only valid options are 1 or 2, please try again.");
                userInput.nextLine();
            }
        }

        switch (answer) {
            case 1:
                System.out.println("What is the ID Number of the student?");
                String IDAnswer = userInput.next();
                boolean lookingForStudent = true;

                for(Student currentStudent : studentDatabase) {
                    if(currentStudent.getID().equals(IDAnswer)) {
                        System.out.println("Name: " + currentStudent.getName());
                        System.out.println("Year: " + currentStudent.getYear());
                        System.out.println("ID: " + currentStudent.getID());
                        System.out.println("Balance: " + currentStudent.getBalance());
                        for(String classes : currentStudent.getEnrolledCourses()) {
                            System.out.print(classes);
                        }
                        lookingForStudent = false;
                    }

                }
                if(lookingForStudent) {
                    System.out.println("Student was not found in database.");
                }
            break;

            case 2:
                for(Student currentStudent : studentDatabase) {
                    System.out.println("Name: " + currentStudent.getName() + " Year: " + currentStudent.getYear() + " ID: " + currentStudent.getID() + " Balance: " + currentStudent.getBalance());
                    for(String classes : currentStudent.getEnrolledCourses()) {
                        System.out.print(classes);
                    }
                }
            break;
        }
    }

    /**
     * Method used to generate a random 4 digit number for the student id and then puts the students year before it to make a complete ID.
     *
     * @param yearAnswer
     * @return fullID
     */
    public StringBuilder generateStudentID(int yearAnswer) {
        int min = 1000;
        int max = 9999;
        Random rand = new Random();
        int randomID = rand.nextInt(max - min + 1 ) + min;

        //concatenate random id number with yearAnswer
        StringBuilder fullID = new StringBuilder();
        fullID.append(yearAnswer);
        fullID.append(randomID);

        return fullID;
    }

    public void studentMode(Scanner userInput) {
        boolean runningStudentMode = true;
        while(runningStudentMode) {
            System.out.println("Please enter your student ID to log in: ");
            String IDAnswer = userInput.next();
            boolean lookingForAnswer = true;
            int answer = 0;
            for(Student currentStudent : studentDatabase) {
                if(currentStudent.getID().equals(IDAnswer)) {
                    System.out.println("Press 1 to enroll in a class:");
                    System.out.println("Press 2 to view your balance:");
                    System.out.println("Press 3 to pay your balance:");
                    while(lookingForAnswer) {
                        try {
                            answer = userInput.nextInt();
                            lookingForAnswer = false;
                        } catch (InputMismatchException e) {
                            System.out.println("The only valid options are 1, 2, or 3 please try again.");
                            userInput.nextLine();
                        }
                    }
                    switch (answer) {
                        case 1:
                            boolean enrollingInClasses = true;
                            while(enrollingInClasses) {
                                enrollInClass(currentStudent, userInput);
                                enrollingInClasses = false;
                            }
                            break;

                        case 2:
                            System.out.println("$" + currentStudent.getBalance());
                            break;
                    }
//test this
                }
                System.out.println("Student not found in database.");
            }
        }

    }

    public void enrollInClass(Student currentStudent, Scanner userInput) {
        boolean lookingForClass = true;
        userInput.nextLine();
        while(lookingForClass) {
            System.out.println("What class would you like to enroll in?");
            String answer = userInput.nextLine();
            for(String currentString : coursesList) {
                if(currentString.equals(answer)) {
                    currentStudent.getEnrolledCourses().add(answer);
                    System.out.println(answer + " has been added to your list of courses.");
                    lookingForClass = false;
                }
            }
            if(lookingForClass) {
                System.out.println("Course not valid. Please enter the exact name of the course.");
            }
        }

    }

    public void payBalance(Student currentStudent, Scanner userInput) {
        double currentBalance = currentStudent.getBalance();
        boolean lookingForAnswer = true;
        while(lookingForAnswer) {
            System.out.println("How much would you like to pay off?");
            try {
                double answer = userInput.nextDouble();
                currentBalance = currentBalance - answer;
                currentStudent.setBalance(currentBalance);
                System.out.println("Balance updated! Your new balance is $" + currentStudent.getBalance());
                lookingForAnswer = false;
            }
            catch (InputMismatchException e) {
                System.out.println("That is not a valid entry. Please enter a amount in the format $00.00");
                userInput.nextLine();
            }

        }

    }


}
