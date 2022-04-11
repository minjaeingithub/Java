package week5;
 
public class Rational extends Number implements Creator {
	
	private long numerator = 0;
	private long denominator = 1;
	
	public Rational() {
		/* Default was 0, 1 */
		this(0,1);
	}
	
	public Rational(long numerator, long denominator) {
		long gcd = gcd(numerator, denominator);
		this.numerator = ((denominator > 0)? 1: -1) * numerator / gcd;
		this.denominator = Math.abs(denominator) / gcd;
	}
	
	private static long gcd(long n, long d) { 
		long a = Math.abs(n);
		long b = Math.abs(d);
		long temp;
		while (b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}
	
	public long getNumerator() {
		return numerator;
	}
	
	public long getDenominator() {
		return denominator;
	}
	
	/* calculation */
	public Rational add(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() + denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational subtract(Rational secondRational) {
		long n = numerator * secondRational.getDenominator() - denominator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational multiply(Rational secondRational) {
		long n = numerator * secondRational.getNumerator();
		long d = denominator * secondRational.getDenominator();
		return new Rational(n,d);
	}
	
	public Rational divide(Rational secondRational) {
		long n = numerator * secondRational.getDenominator();
		long d = denominator * secondRational.getNumerator();
		return new Rational(n,d);
	}
	
	@Override
	public String toString() {
		if(this.denominator == 1) {
			return this.numerator + " " ;
			}
		else
			return " " + this.numerator + "/" +this.denominator;
	}
	
	@Override
	public boolean equals(Object other) {
		//ad-bc == 0 overloading
		if(this.subtract((Rational) (other)).getNumerator()==0) {
			return true;
		} else 
			return false; 
		}
		
	@Override
	public void CreatorOfThisClass() {
		System.out.println("Creator of this class is Minjae Jo");
	}

	@Override
	public int intValue() {
		long result = (int) doubleValue();
		return (int) result;
	}

	@Override
	public long longValue() {
		long result = (long) doubleValue();
		return (long) result;
	}

	@Override
	public float floatValue() {
		float result = (float) doubleValue();
		return result;
	}

	@Override
	public double doubleValue() {
		double result = this.numerator * (1.0) / this.denominator;
		return result;
	}
}