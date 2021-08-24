import java.math.BigDecimal;
import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private String ID;
    private BigDecimal balance;
    private ArrayList<String> enrolledCourses;


    public Student(String name, int year, String ID) {
        this.name = name;
        this.year = year;
        this.ID = ID;
        balance = new BigDecimal("0.00");
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal newBalance) {
        this.balance = newBalance;
    }

    public ArrayList<String> getEnrolledCourses() {
        return enrolledCourses;
    }


}
