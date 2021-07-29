public class Student {
    private String name;
    private int year;
    private int ID;
    private double balance;


    public Student(String name, int year, int ID) {
        this.name = name;
        this.year = year;
        this.ID = ID;
        balance = 0;
    }

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
