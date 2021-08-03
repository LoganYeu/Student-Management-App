import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private String ID;
    private double balance;
    private ArrayList<String> enrolledCourses;


    public Student(String name, int year, String ID) {
        this.name = name;
        this.year = year;
        this.ID = ID;
        balance = 0;
        enrolledCourses = new ArrayList<String>();
    }

    /**
     * Generates a unique 5 digit ID for a student.
     *
     * @return studentID
     */
    /*public int generateUniqueID() {

    }*/

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    private String getID() {return ID;}

    public double getBalance() {
        return balance;
    }


}
