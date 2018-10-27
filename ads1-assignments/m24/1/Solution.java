import java.util.Scanner;
import java.util.Arrays;
class Student {

	int roll_num;
	String student_name;
	double total_marks;

	private Student() {

	}

	Student(final int roll, final String student,
										 final double marks) {
		this.roll_num = roll;
		this.student_name = student;
		this.total_marks = marks;
	}

	public String getname() {

		return this.student_name;
	}

	public double getMarks() {
		return this.total_marks;
	}

	public int getRoll() {
		return this.roll_num;
	}

}

public class Solution {

	private Solution() {

	}

public static void main(String[] args) {

	Scanner scan = new Scanner(System.in);
	int no_Of_Students = Integer.parseInt(scan.nextLine());

	// System.out.println(no_Of_Students);

    Student[] studentArray = new Student[no_Of_Students];

    int size = 0;


	for(int i = 0; i < no_Of_Students; i++) {

		String[] studentData = scan.nextLine().split(",");

		// System.out.println(Arrays.toString(studentData));

		Student studentInfo = new Student(Integer.parseInt(studentData[0]),
			 studentData[1], Double.parseDouble(studentData[2]));

	studentArray[size] = studentInfo;
	size++;

	}

	int no_Of_Queires = Integer.parseInt(scan.nextLine());

	// System.out.println(no_Of_Queires);

	for(int j = 0; j < no_Of_Queires; j++) {

		int flag = 0;
		String[] query = scan.nextLine().split(" ");

		// System.out.println(Arrays.toString(query));

		switch(query[2]){

			case "1":

				for (int k = 0; k < size; k++) {

					// System.out.println(k);

					if(studentArray[k].getRoll() == Integer.parseInt(query[1])) {
						System.out.println(studentArray[k].getname());

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

				for (int k = 0; k < size; k++) {

					if(studentArray[k].getRoll() == Integer.parseInt(query[1])) {
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

