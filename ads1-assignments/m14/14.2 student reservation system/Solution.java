import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for seat.
 */
class Seat implements Comparable<Seat> {
  /**
   * student/applicant name.
   */
  private String studentName;
  /**
   * reservation category.
   */
  private String reservationCategory;

  /**
   * Declaration for marks/merit and date of birth.
   */
  private int sub1Marks, sub2Marks, sub3Marks, totalMarks, date, month, year;
  /**
   * Constructs the object.
   *
   * @param      name  The name
   * @param      dOB   The date of birth
   * @param      s1m   The subject 1 marks
   * @param      s2m   The subject 2 marks
   * @param      s3m   The subject 3 marks
   * @param      tm    The time
   * @param      rc    The reservation category
   */
  Seat(final String name, final int[] dOB, final int s1m, final int s2m,
   final int s3m, final int tm, final String rc) {

    studentName = name;
    date = dOB[0];
    month = dOB[1];
    year = dOB[2];
    sub1Marks = s1m;
    sub2Marks = s2m;
    sub3Marks = s3m;
    totalMarks = tm;
    reservationCategory = rc;
  }

  /**
   * Gets the rc.
   *
   * @return     The rc.
   */
  public String getReservation() {
    return reservationCategory;
  }
  /**
   * Compare to.
   *
   * @param      other  The other
   *
   * @return     integer.
   */
  public int compareTo(final Seat other) {
    if (this.totalMarks > other.totalMarks) {
      return 1;
    }
    if (this.totalMarks < other.totalMarks) {
      return -1;
    }
    if (this.sub3Marks > other.sub3Marks) {
      return 1;
    }
    if (this.sub3Marks < other.sub3Marks) {
      return -1;
    }
    if (this.sub2Marks > other.sub2Marks) {
      return 1;
    }
    if (this.sub2Marks < other.sub2Marks) {
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
    return 0;
  }
  /**
   * Returns a string representation of the object.
   *
   * @return     String representation of the object.
   */
  public String toString() {
    return studentName + "," + totalMarks + "," + reservationCategory;
  }
}
/**
 * Class for Heap Sort.
 */
final class Heapsort {
  /**
   * Constructs the object.
   */
  private Heapsort() {
    /**
     * Unused.
     */
  }
  /**
   * Sort function.
   *
   * @param      a     Array
   */
  static void sort(final Comparable[] a) {
    int size = a.length;
    for (int k = size / 2; k >= 1; k--) {
      sink(a, k, size);
    }
    while (size > 1) {
      swap(a, 1, size--);
      sink(a, 1, size);
    }
  }
  /**
   * Sink Function.
   *
   * @param      pq    { parameter_description }
   * @param      k     { parameter_description }
   * @param      n     { parameter_description }
   */
  static void sink(final Comparable[] pq, final int k, final int n) {
    int k1 = k;
    while (2 * k1 <= n) {
      int j = 2 * k1;
      if (j < n && more(pq, j, j + 1)) {
        j++;
      }
      if (!more(pq, k1, j)) {
        break;
      }
      swap(pq, k1, j);
      k1 = j;
    }
  }
  /**
   * Swap function.
   *
   * @param      a     Array
   * @param      i     index
   * @param      j     index
   */
  static void swap(final Comparable[] a, final int i, final int j) {
    Comparable temp = a[i - 1];
    a[i - 1] = a[j - 1];
    a[j - 1] = temp;
  }
  /**
   * More function.
   *
   * @param      a     array
   * @param      i     index
   * @param      j     index
   *
   * @return     boolean
   */
  static boolean more(final Comparable[] a, final int i, final int j) {
    return a[i - 1].compareTo(a[j - 1]) > 0;
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
    /**
     * Unused.
     */
  }
  /**
   * Seat Allotment.
   *
   * @param      a     array
   * @param      vac   The vac
   * @param      open  The open vac
   * @param      bc    The bc vac
   * @param      sc    The sc vac
   * @param      st    The st vac
   */
  public static void seatAllotment(final Seat[] a, final int vac,
   final int open, final int bc, final int sc, final int st) {

    int vac1 = vac;
    int open1 = open;
    int bc1 = bc;
    int sc1 = sc;
    int st1 = st;
    Heapsort.sort(a);
    String s = "";
    for (int j = 0; j < a.length; j++) {
      s += a[j].toString() + "\n";
    }
    System.out.println(s);
      // printing sorted applications based on merit.

    int count = 0, countBC = 0, countSC = 0, countST = 0;

    for (int m = 0; m < a.length; m++) {
        // counting no.of applicants of each category.
      if (a[m].getReservation().equals("ST")) {
            countST += 1;
          } else if (a[m].getReservation().equals("SC")) {
              countSC += 1;
          } else if (a[m].getReservation().equals("BC")) {
              countBC += 1;
          }
    }

    Seat[] allotment = new Seat[vac];
    for (int i = 0; i < a.length; i++) {
      if (count < open) {
        if (a[i].getReservation().equals("ST")) {
            allotment[count++] = a[i];
            countST--;
          } else if (a[i].getReservation().equals("SC")) {
              allotment[count++] = a[i];
              countSC--;
          } else if (a[i].getReservation().equals("BC")) {
              allotment[count++] = a[i];
              countBC--;
          } else {
              allotment[count++] = a[i];
          }

      }  else {
          if (a[i].getReservation().equals("ST") && st1 != 0) {
            allotment[count++] = a[i];
            st1--;
            countST--;

          } else if (a[i].getReservation().equals("SC") && sc1 != 0) {
              allotment[count++] = a[i];
              sc1--;
              countSC--;

          } else if (a[i].getReservation().equals("BC") && bc1 != 0) {
              allotment[count++] = a[i];
              bc1--;
              countBC--;
          }
      }
    }

    if (count <= vac) {
      for (int l = open; l < a.length; l++) {
        if (bc1 != 0 && !Arrays.asList(allotment).contains(a[l])) {
          allotment[count++] = a[l];
          bc1--;
        } else if (sc1 != 0 && !Arrays.asList(allotment).contains(a[l])) {
          allotment[count++] = a[l];
          sc1--;
        } else if (st1  != 0 && !Arrays.asList(allotment).contains(a[l])) {
          allotment[count++] = a[l];
          st1--;
        }
      }
    }
    Heapsort.sort(allotment);
    String str = "";
    for (int k = 0; k < allotment.length; k++) {
      str += allotment[k].toString() + "\n";
    }
    System.out.println(str);
  }

  /**
   * Main function.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = Integer.parseInt(scan.nextLine());
    Seat[] applications = new Seat[n];
    int size = 0;
    int vacancies = Integer.parseInt(scan.nextLine());
    int unReserved = Integer.parseInt(scan.nextLine());
    int bc = Integer.parseInt(scan.nextLine());
    int sc = Integer.parseInt(scan.nextLine());
    int st = Integer.parseInt(scan.nextLine());

    while (scan.hasNext()) {

      String[] details = scan.nextLine().split(",");


      String[] dob = details[1].split("-");
      int[] dobArray = new int[dob.length];
            //int[] with date, month, year.
      for (int i = 0; i < dob.length; i++) {
        dobArray[i] = Integer.parseInt(dob[i]);
      }

      applications[size++] = new Seat(details[0], dobArray,
       Integer.parseInt(details[2]), Integer.parseInt(details[2 + 1]),
        Integer.parseInt(details[2 + 2]),
         Integer.parseInt(details[2 + 2 + 1]), details[2 + 2 + 2]);
    }
    scan.close();
    seatAllotment(applications, vacancies, unReserved, bc, sc, st);
  }
}