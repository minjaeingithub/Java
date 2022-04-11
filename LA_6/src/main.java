import java.util.Scanner;
import week7.Timetable;


public class main {
	public static void main(String[] args) {
		Timetable new_timetable = new Timetable();
		
		/*Scanner scn = new Scanner(System.in);
		System.out.println("Enter Class ID, Class Name and Time: ");
		String str = scn.nextLine();*/
		new_timetable.AddClass("BCDE234 ClassB MON1800");	
		new_timetable.AddClass("ABCD123 ClassA MON0900");
		new_timetable.AddClass("BCDE234 ClassB MON1800");
		new_timetable.ShowTables(new_timetable.classList);
		System.out.println(new_timetable.FindClassName("ABCD123"));
		System.out.println(new_timetable.FindClassID("ClassA"));
		new_timetable.AddClass("ABDE356 ClassC TUE1500");
		new_timetable.ShowTables(new_timetable.classList);
	}
}
