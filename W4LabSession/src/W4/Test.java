package W4;
import W4.Custom_Int;
public class Test {

	public static void main(String[] args) {
		Custom_Int a = new Custom_Int (32768);
		Custom_Int b = new Custom_Int (131072);
		
		a.Sum(65536);
		System.out.println(a.num + " " + b.num);
		
		b.Subtract(1024);
		System.out.println(a.num + " " + b.num);
		
		b.Multiply(9);
		System.out.println(a.num + " " + b.num);
		
		a.Division(2);
		System.out.println(a.num + " " + b.num);

		Custom_Int gcd = a.get_GCD(b);
		
		System.out.println(gcd.num);
	}

}
