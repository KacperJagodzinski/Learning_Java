import java.util.Scanner;

public class Student {
    private int year;
    private String firstName;
    private String lastName;
    private String studentId;
    private String courses = "";
    private int tuitionBalance = 0;
    private static int courseCost = 600;
    private static int id = 1000;

    public Student() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter student first name: ");
        this.firstName = scanner.nextLine();
        System.out.println("Enter student last name: ");
        this.lastName = scanner.nextLine();
        System.out.println("Enter student class level: \n 1 - Freshman\n2 - Sophomore\n3 - Junior\n4 - Senior\n");
        this.year = scanner.nextInt();
        setID();
        System.out.println(firstName + " " + lastName + " " + year + " ID: " + studentId);
    }

    private void setID() {
        id++;
        this.studentId = year + "" + id;
    }

    public void enroll(){

        do {
            System.out.println("Enter course to enroll (Q to quit)");
            Scanner in = new Scanner(System.in);
            String course = in.nextLine();
            if (!(course.toLowerCase().equals("q"))) {
                this.courses = courses + "\n" + course;
                tuitionBalance = tuitionBalance + courseCost;
            } else {
                break;
            }
        }while (true);
            System.out.println("ENROLED IN: " + this.courses);
            System.out.println("TUITION BALANCE: " + this.tuitionBalance);


    }

    public void vievBalance(){
        System.out.println("Balance: " + tuitionBalance);
    }

    public void payTuition(){
        vievBalance();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your payment");
        int payment = scanner.nextInt();
        tuitionBalance -= payment;
        System.out.println("Thank you for your payment");
        vievBalance();
    }

    public String showInfo(){
        return "Name: " + firstName + " " + lastName +
                "\nCourses enrolled: " + courses +
                "\nBalance: $" + tuitionBalance;
    }
}
