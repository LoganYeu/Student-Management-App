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



    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getID() {
        return ID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double newBalance) {
        this.balance = newBalance;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }


}
