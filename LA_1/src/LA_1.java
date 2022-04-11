import java.util.Scanner;

public class LA_1 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int i = scn.nextInt();
		scn.nextLine();
		String result1="";
		String result2="";

		//binary
			for(int num=i; num> 0; num/=2)	
				result1 = String.valueOf(num%2) + result1;

		//octal
			for(int num=i; num>0; num/=8)
				result2 = String.valueOf(num%8) + result2;

			if(i==0) {
				System.out.println("b " + i);
				System.out.println("o " + i);
			}
			else {
				System.out.println("b " + result1);
				System.out.println("o " + result2);
			}
		hexa(i);		
	}			
		//hexadecimal
	public static void hexa(int input) {
		String result3="";
		char sibyook_System[]= {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
			for(int a=input; a>0; a/=16) {
				result3= sibyook_System[a%16]+result3;
			}
			if(input == 0) {
				System.out.println("h " + input);
			}
		
			else
				System.out.println("h " + result3);
		}
}