package email;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private String email;
    private String companySufix = "company.com";

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        //System.out.println("Email created: " + this.firstName);
        this.department = setDepartment();
        //System.out.println("Department: " + this.department);
        this.password = randomPassword(defaultPasswordLength);
        //System.out.println("Password: " + this.password);

        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySufix;
        System.out.println("Your email: " + email);
    }

    private String setDepartment(){
        System.out.print("What department? \n1 - Sales\n2 - Development\n3 - Accounting\n4 - None\n");
        Scanner scanner = new Scanner(System.in);
        int departmentI = scanner.nextInt();
        if(departmentI == 1){return "sales";}
        else if(departmentI == 2) {return "dev";}
        else if(departmentI == 3) {return "acct";}
        else {return "";}
    }

    private String randomPassword(int length){
        String passwordSet = "ABCDEFGJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*(()";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int mailboxCapacity) {
        this.mailboxCapacity = mailboxCapacity;
    }

    public void setAlternateEmail(String alternateEmail) {
        this.alternateEmail = alternateEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String getPassword() {
        return password;
    }

    public String showInfo(){
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "COMPANY EMAIL: " + email +
                "MAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
