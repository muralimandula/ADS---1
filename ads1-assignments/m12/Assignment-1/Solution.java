import java.util.Scanner;

/**
 * Class for team object.
 * We use comparable interface to implement sort algortihms.
 */
class Student implements Comparable<Student> {

     private String studentName;

     private String dob;

     private int sub1;

     private int sub2;

     private int sub3;

     private int total;

     private String reservation;

     // private String[] dobDetails = dob.split("-");

     private int date;

     private int month;

     private int year;



    Student(final String nameOftheStudent, final String doBirth,
                            final int sub1Marks, final int sub2Marks,
                             final int sub3Marks, final int totalMarks,
                                                     final String reserved,
            final int dobDate, final int dobMonth, final int dobYear) {
        this.studentName = nameOftheStudent;
        this.dob = doBirth;
        this.sub1 = sub1Marks;
        this.sub2 = sub2Marks;
        this.sub3 = sub3Marks;
        this.total = totalMarks;
        this.reservation = reserved;
        this.date = dobDate;
        this.month = dobMonth;
        this.year = dobYear;
    }

    /**
     * Compares two objects of this class.
     * Complexity Analysis: O(1).
     *
     * @param      other  The other
     *
     * @return     1 if greater
     *             0 if equal.
     *             -1 if lesser.
     */
    public int compareTo(final Student other) {
        if (this.total > other.total) {
         return 1;
        }
        if (this.total < other.total) {
                return -1;
        }
        if (this.sub3 > other.sub3) {
                return 1;
        }
        if (this.sub3 < other.sub3) {
                return -1;
        }
        if (this.sub2 > other.sub2) {
                return 1;
        }
        if (this.sub2 < other.sub2) {
                return -1;
        }
        if (this.sub1 > other.sub1) {
                return 1;
        }
        if (this.sub1 < other.sub1) {
                return -1;
        }


        if (this.year > other.year) {
                return 1;
        }
        if (this.year < other.year) {
                return -1;
        }
        if (this.month > other.month) {
                return 1;
        }
        if (this.month < other.month) {
                return -1;
        }
        if (this.date > other.date) {
                return 1;
        }
        if (this.date < other.date) {
                return -1;
        }


        else {
                return 0;
         }
        }

    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return studentName +  "," + total + "," + reservation;
    }

    public String getReservation() {
        return this.reservation;
    }
}

/**
 * Class for insertion sort of applications.
 */
final class InsertionSortApplications {

        /**
         * Constructs the object.
         */
        private InsertionSortApplications() {
                //dummy constructor.
        }
    /**
     * To check if the object is greater.
     *
     * @param      a     team 1
     * @param      b     team 2
     *
     * @return     returns true if team 1 is greater than
     * team 2 on the leader board.
     */
    static boolean more(final Comparable a, final Comparable b) {
        return a.compareTo(b) > 0;
    }

    /**
     * Swaps 2 objects in the array of objects.
     *
     * @param      a     Array of objects.
     * @param      i     Object 1.
     * @param      j     Object 2.
     */
    static void swap(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Sorts the array of objects using Insertion Sort.
     *
     * Best Case: N-1 compares and 0 exchanges.
     * Average Case: (N^2)/4 compares and (N^2)/4 exchanges.
     * Worst Case: (N^2)/2 compares and (N^2)/2 exchanges.
     *
     * @param      applicationsObjectArr   The array of apllications.
     * @param      size  The number of objects in the array.
     */
    static void sort(final Comparable[] applicationsObjectArr, final int size) {

        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {

                if (more(applicationsObjectArr[j], applicationsObjectArr[j - 1])) {
                        swap(applicationsObjectArr, j, j - 1);   // Swapping team positions.
                }
            }
        }
    }
}


/**
 * Class for Solution.
 */
public final class Solution {
    /**
     * Avoid magic numbers.
     */
    static final int THREE = 3;


    /**
     * Avoid magic numbers.
     */
    static final int FOUR = 4;

    /**
     * Avoid magic numbers.
     */
    static final int FIVE = 5;

    /**
     * Avoid magic numbers.
     */
    static final int SIX = 6;




    /**
     * Avoid magic numbers.
     */
    static final int TEN = 10;

    /**
     * Constructs the object.
     */
    private Solution() {
        // unused constructor
    }


    public static void applicationChart(final Student[] apllicantions,
                                final int noOfApplicants, final int vacancies,
                                final int unreserved, final int bc, final int sc,
                                                                 final int st) {

        InsertionSortApplications.sort(apllicantions, noOfApplicants);

        for (int i = 0; i < noOfApplicants; i++) {
            // chart += apllicantions[i].toString();
            // chart += ",";
            System.out.println(apllicantions[i]);
        }
        // chart = chart.substring(0, chart.length() - 1);
        // return "";
        //
        System.out.println("");

        int occ = 0;

        for (int i = 0; i < unreserved; i++) {

            // System.out.println(i);
            System.out.println(apllicantions[i]);

            occ += 1;
            // System.out.println(apllicantions[i].getReservation());

        }

        // System.out.println("");

        // System.out.println(occ);

        int scCount = 0;
        int stCount = 0;
        int bcCount = 0;



        for (int j = unreserved; j < noOfApplicants && occ <= vacancies; j++) {

            // if(apllicantions[j].getReservation().equals("SC") || apllicantions[j].getReservation().equals("ST") || apllicantions[j].getReservation().equals("BC")) {

                if(apllicantions[j].getReservation().equals("SC") && scCount < sc) {
                System.out.println(apllicantions[j]);
                scCount += 1;
                occ += 1;
                }

                if(apllicantions[j].getReservation().equals("ST") && stCount < st) {
                System.out.println(apllicantions[j]);
                stCount += 1;
                occ += 1;

            }

                if(apllicantions[j].getReservation().equals("BC") && bcCount < bc) {
                System.out.println(apllicantions[j]);
                bcCount += 1;
                occ += 1;
                }


            // }
        }





    }

    /**
     * Main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);




        int noOfApplicants = Integer.parseInt(scan.nextLine());

        Student[] applications = new Student[noOfApplicants];


        int noOfVacancies = Integer.parseInt(scan.nextLine());
        int noOfUnreserved = Integer.parseInt(scan.nextLine());
        int noOfBC = Integer.parseInt(scan.nextLine());
        int noOfSC = Integer.parseInt(scan.nextLine());
        int noOfST = Integer.parseInt(scan.nextLine());
        int size = 0;


        for(int i = 0; i < noOfApplicants; i++) {

        String[] application = scan.nextLine().split(",");

        String[] dobDetails = application[1].split("-");


        Student newApplication = new Student(application[0], application[1],
                                            Integer.parseInt(application[2]),
                                            Integer.parseInt(application[THREE]),
                                              Integer.parseInt(application[FOUR]),
                                               Integer.parseInt(application[FIVE]),
                                                                   application[SIX],
        Integer.parseInt(dobDetails[0]), Integer.parseInt(dobDetails[1]), Integer.parseInt(dobDetails[2]));

        applications[size] = newApplication;
        size += 1;
        }
        applicationChart(applications, size, noOfVacancies,
                         noOfUnreserved, noOfBC, noOfSC, noOfST);
    }
}
