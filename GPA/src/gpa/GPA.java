//Intent: calculate gpa for all 4 years of h.s
package gpa;

import java.util.Date;
import java.util.Scanner;

class GPA {

    public static void main(String[] args) {
        //declare variables
        Date today = new Date();
        Scanner reader = new Scanner(System.in);
        char response = 'y', lettergrade, typeofclass;
        String name = new String();
        String subject = new String();
        String temp = new String();
        double totalGPA = 0.0;
        double totalGPA2 = 0.0;
        double averageGPA = 0.0;
        double weightfactor = 0.0;

        //input information
        //start while
        while (response == 'y' || response == 'Y')
        {
            //input student's name
            System.out.println("enter student's name.");
            name = reader.nextLine();

            for (int i = 1; i < 5; i++) //subjects' for loop
            {
                //switch case for classes
                switch (i) {
                    case 1:
                        subject = "Math";
                        break;
                    case 2:
                        subject = "English";
                        break;
                    case 3:
                        subject = "Science";
                        break;
                    case 4:
                        subject = "History";
                        break;
                    default:
                        subject = "Other class";
                }
                //input class type
                System.out.println("type of class for " + subject + ", (A)P, (H)onors, or (R)egular");
                temp = reader.next();
                typeofclass = temp.toUpperCase().charAt(0);
                totalGPA = 0;
                //input letter grade
                for (int mp = 1; mp < 6; mp++) {
                    System.out.println("enter letter grade for  " + subject + " for Marking Period :" + mp);
                    temp = reader.next();
                    lettergrade = temp.toUpperCase().charAt(0);
                    //wrong letter grade
                    if (!(lettergrade == 'A' || lettergrade == 'B' || lettergrade == 'C' || lettergrade == 'D' || 
lettergrade == 'F')) {
                        System.out.println("error: invalid letter grade: " + lettergrade);
                        mp--;
                        continue;

                    }
                    //calculate GPA


                    switch (lettergrade) {
                        case 'A': {
                            totalGPA = totalGPA + 4.0;
                            break;
                        }
                        case 'B': {
                            totalGPA = totalGPA + 3.0;
                            break;
                        }
                        case 'C': {
                            totalGPA = totalGPA + 2.0;
                            break;
                        }
                        case 'D': {
                            totalGPA = totalGPA + 1.0;
                            break;
                        }
                        case 'F': {
                            totalGPA = totalGPA + 0.0;
                            break;
                        }
                        default:
                            totalGPA = totalGPA + 0.0;
                            break;
                    }


                }

                switch (typeofclass) {
                    case 'A': {
                        weightfactor = 1.0;
                        break;
                    }
                    case 'H': {
                        weightfactor = 0.5;
                        break;
                    }
                    case 'R': {
                        weightfactor = 0.0;
                        break;
                    }
                    default: {
                        weightfactor = 0.0;
                        break;
                    }

                }
                //calculate
                totalGPA = (totalGPA / 5) + weightfactor;
                totalGPA2 = (totalGPA2 + totalGPA);
                System.out.println("Current GPA: " + totalGPA);
               

            }
            //create average gpa
            averageGPA = totalGPA2 / 4;
            System.out.println("your average GPA is: " + averageGPA);
            //determine honor roll
            if (averageGPA >= 3.5) {
                System.out.println("you made Honor Roll");

            } else {
                System.out.println();
            }
            System.out.println("press enter to continue");

            temp = "";
            temp = reader.next();
            //ask for another gpa
            System.out.println("calculate another GPA? y/n");
            temp = reader.next();
            response = temp.charAt(0);

 

 

        } //end while
        System.out.println();
        System.out.println();
        System.out.println(today);    

 

    }
}