import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private int ID;
    private double balance;
    private ArrayList<String> enrolledCourses;


    public Student(String name, int year, int ID) {
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

    public double getBalance() {
        return balance;
    }


}
