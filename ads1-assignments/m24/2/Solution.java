import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for student.
 */
class Student {

    /**
     * Student roll number.
     */
    private int rollnum;

    /**
     * Student Name.
     */
    private String studentname;

    /**
     * Student total marks.
     */
    private double totalmarks;

    /**
     * Constructs the object.
     */
    private Student() {

    }

    /**
     * Constructs the object.
     *
     * @param      roll     The roll
     * @param      student  The student
     * @param      marks    The marks
     */
    Student(final int roll, final String student,
                                         final double marks) {
        this.rollnum = roll;
        this.studentname = student;
        this.totalmarks = marks;
    }


    /**
     * Gets the name.
     *
     * @return     The name of student.
     */
    public String getName() {

        return this.studentname;
    }

    /**
     * Gets the marks.
     *
     * @return     The marks.
     */
    public double getMarks() {
        return this.totalmarks;
    }

    /**
     * Gets the roll.
     *
     * @return     The roll.
     */
    public int getRoll() {
        return this.rollnum;
    }

}


/**
 * Class for solution.
 */
public final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {
        //dummy constructor.
    }


/**
 * Main Method.
 *
 * @param      args  The arguments
 */
public static void main(final String[] args) {

    Scanner scan = new Scanner(System.in);
    int noOfStudents = Integer.parseInt(scan.nextLine());


    Student[] studentArray = new Student[noOfStudents];

    Double[] marksArray = new Double[noOfStudents];
    int size = 0;


    /**
     * Inserting student details.
     * Time Complexity : N (N is no.of applicants)
     */
    for (int i = 0; i < noOfStudents; i++) {

        String[] studentData = scan.nextLine().split(",");

        Student studentInfo = new Student(Integer.parseInt(studentData[0]),
             studentData[1], Double.parseDouble(studentData[2]));

    studentArray[size] = studentInfo;
    marksArray[size] = Double.parseDouble(studentData[2]);
    size++;

    }

    Arrays.sort(marksArray);
    // System.out.println(Arrays.toString(marksArray));


    int noOfQueires = Integer.parseInt(scan.nextLine());

    /**
     * Retrieving student details.
     * Time Complexity : N (N is no.of Queries)
     */
    for (int j = 0; j < noOfQueires; j++) {

        int flag = 0;
        String[] query = scan.nextLine().split(" ");





        switch (query[0]) {

            case "BE":

            double greater = Double.parseDouble(query[1]);

            double lesser = Double.parseDouble(query[2]);


                /**
                 * To find name of Students with rollNum.
                 * Unordered Selection
                 * TIme Complexity - Worse case = N (Checking all)
                 * TIme Complexity - Best case = 1 (May encounter at first)
                 */
                for (int k = 0; k < size; k++) {
                    if (marksArray[k] >= greater && marksArray[k] <= lesser) {

                        for (int m = 0; m < size; m++) {
                            if(studentArray[m].getMarks() == marksArray[k]) {
                            System.out.println(studentArray[m].getName());
                            flag = 1;
                            break;
                            }

                        }
                    }

                }
                if (flag == 0) {
                    System.out.println("Student doesn't exists...");
                }
                flag = 0;

            break;

            case "LE":


                /**
                 * To find name of Students with rollNum.
                 * Unordered Selection
                 * TIme Complexity - Worse case = N (Checking all)
                 * TIme Complexity - Best case = 1 (May encounter at first)
                 */

                for (int k = 0; k < size; k++) {
                    if (marksArray[k] <= Double.parseDouble(query[1])) {

                        for (int m = 0; m < size; m++) {
                            if(studentArray[m].getMarks() == marksArray[k]) {
                            System.out.println(studentArray[m].getName());
                            flag = 1;
                            break;
                            }

                        }
                    }

                }
                if (flag == 0) {
                    System.out.println("Student doesn't exists...");
                }
                flag = 0;

            break;


            case "GE":


                /**
                 * To find TotalMarks of Students with rollNum.
                 * Unordered Selection
                 * TIme Complexity - Worse case = N (Checking all)
                 * TIme Complexity - Best case = 1 (May encounter at first)
                 */

                for (int k = 0; k < size; k++) {
                    if (marksArray[k] >= Double.parseDouble(query[1])) {

                        for (int m = 0; m < size; m++) {
                            if(studentArray[m].getMarks() == marksArray[k]) {
                            System.out.println(studentArray[m].getName());
                            flag = 1;
                            break;
                            }

                        }
                    }

                }
                if (flag == 0) {
                    System.out.println("Student doesn't exists...");
                }
                flag = 0;

            break;


            default:
            break;


        }




    }
}
}

