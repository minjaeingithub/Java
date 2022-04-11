import java.util.Scanner;

public class StringMethod {
	// Returns the string created by adding 's2' after position 'index' of's1'. 
	static String stringToNum(String s) {
		String[] array1 = s.split(" ");
		String conversion1 = "";
		for(int i=0; i<=array1.length-1;i++) {
			switch(array1[i]) {
			case "Zero":
				conversion1 += "0";
				break;
			case "One":
				conversion1 += "1";
				break;
			case "Two": 
				conversion1 += "2";
				break;
			case "Three":
				conversion1 += "3";
				break;
			case "Four":
				conversion1 += "4";
				break;
			case "Five":
				conversion1 += "5";
				break;
			case "Six":
				conversion1 += "6";
				break;
			case  "Seven":
				conversion1 += "7";
				break;
			case "Eight":
				conversion1 += "8";
				break;
			case "Nine":
				conversion1 += "9";
				break;	
			}
		
		}
		return conversion1;
	}
	
	// Returns three numbers in alphabetical ascending order
	static String orderString(String s) {
		String[] array2 = s.split(" ");
		String conversion2 = "";
		String a = array2[0] + " ";
		String b = array2[1] + " ";
		String c = array2[2] + " ";
			
			if(a.charAt(0) > b.charAt(0)){
				if(a.charAt(0)> c.charAt(0))
				{
					if(b.charAt(0)>c.charAt(0)) {
						conversion2 = c + b + a;
					}
					else
						conversion2 = b + c + a;
				}
				else
					conversion2 = b + a + c;
			}
			else
			{
				if(b.charAt(0) > c.charAt(0))
				{
					if(a.charAt(0) > c.charAt(0)) {
						conversion2 = c + a + b;
					}
					else
						conversion2 = a + c + b;
				}
				else 
					conversion2 = a + b + c;
			}
			return conversion2;
			}

	// Returns reversed string of 's'
	static String reverse(String s) {
		String conversion3 = stringToNum(s);
		char[] changedStr = conversion3.toCharArray();
		char[] reversedArr = new char[changedStr.length];
		for(int i=0; i<changedStr.length;i++) {
			reversedArr[changedStr.length-1-i] = changedStr[i];
		}
		
		String reversedStr = new String(reversedArr);
		return reversedStr ;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.nextLine();
	
		System.out.println(stringToNum(str));
		System.out.println(orderString(str));
		System.out.println("Reverse number is : " + reverse(str));
	}
}