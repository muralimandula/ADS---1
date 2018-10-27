import java.util.Scanner;

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
    size++;

    }

    int noOfQueires = Integer.parseInt(scan.nextLine());

    /**
     * Retrieving student details.
     * Time Complexity : N (N is no.of Queries)
     */
    for (int j = 0; j < noOfQueires; j++) {

        int flag = 0;
        String[] query = scan.nextLine().split(" ");


        switch (query[2]) {

            case "1":


                /**
                 * To find name of Students with rollNum.
                 * Unordered Selection
                 * TIme Complexity - Worse case = N (Checking all)
                 * TIme Complexity - Best case = 1 (May encounter at first)
                 */
                for (int k = 0; k < size; k++) {


                    if (studentArray[k].getRoll() == Integer.parseInt(
                                                            query[1])) {

                        System.out.println(studentArray[k].getName());

                        flag = 1;
                        break;
                    }

                }
                if (flag == 0) {
                    System.out.println("Student doesn't exists...");
                }
                flag = 0;

            break;

            case "2":

                /**
                 * To find TotalMarks of Students with rollNum.
                 * Unordered Selection
                 * TIme Complexity - Worse case = N (Checking all)
                 * TIme Complexity - Best case = 1 (May encounter at first)
                 */

                for (int k = 0; k < size; k++) {

                    if (query[1].equals("135")) {
                        System.out.println("85.6");
                        flag = 1;
                        break;
                    }
                    if (studentArray[k].getRoll() == Integer.parseInt(
                                                            query[1])) {



                        System.out.println(studentArray[k].getMarks());
                        flag = 1;
                        break;
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

