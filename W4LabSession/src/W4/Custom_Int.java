package W4;

public class Custom_Int {
	int num;
	
	Custom_Int (int num) {
		/* constructor */
		this.num = num;
	}
	
	void Sum (int n) {
		/* Fill Here */
		num += n;
	}
	
	void Subtract (int n) {
		/* Fill Here */
		num -= n;
	}
	
	void Multiply (int n) {
		/* Fill Here */
		num *= n;
	}
	
	void Division (int n) {
		/* Fill Here */
		num /= n; 
	}
	
	private int GCD(int num1, int num2) {
		if (num1 % num2 == 0) {
			return num2;
		}
		else 
			return GCD(num2, num1 % num2);
		}

	Custom_Int get_GCD (Custom_Int b) {
		/* Fill Here */
		num = GCD (this.num, b.num);
	// You have to return Custom_Int object that has gcd of a and b.
		return	this;
	}
}