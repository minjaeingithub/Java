import java.io.*;
import java.util.Scanner;
public class SimpleCalculator {
	int result=0;
	
	//necessary methods for CALCULATION
	void add(int a, int b) {
		result = a+b;
	}
	
	void subtract(int a, int b) {
		result = a-b;
	}
	
	void multiply(int a, int b) {
		result = a*b;
	}
	
	void divide(int a, int b) {
		result = a/b;
	}
	
	void print() {
		System.out.println(result);
	}
	
	void reset() {
		result = 0;
	}
	
	int getResult() {
		return result;
	}
	
	void setResult(int input) {
		this.result = input;
	}
//User-defined exceptions from here
class OutofRangeException extends Exception {
	private String message;
	public OutofRangeException(String message) {
		this.message = message;
	}
}
public int checkRange() throws OutofRangeException {
	getResult();
	if(result < 0 || result > 65536) {
		throw new OutofRangeException("OutofRange");
	}
	return result;
}

class IllegalDivisionException extends Exception {
	private String message;
	public IllegalDivisionException(String message) {
		this.message = message;
	}
}
public int checkIllegalDivision() throws IllegalDivisionException {
	Scanner scn = new Scanner(System.in);
	int a = scn.nextInt();
	int b = scn.nextInt();
	setResult(b);
	
	if(result == 0) {
		throw new IllegalDivisionException("IllegalDivision");
	}
	else 
		divide(a,b);
	return result;
}

class NotDividedException extends Exception {
	private String message;
	public NotDividedException(String message) {
		this.message = message;
	}
}
public int checkDivision() throws NotDividedException {
	if(((Object)result).getClass().getSimpleName() != "Integer") {
		throw new NotDividedException("NotDivided");
	}
	return result;
}
}