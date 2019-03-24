package test;


public class Main {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		
		System.out.println("Before : " + a + " " + b);
		
		a = a+b;
		b = a-b;
		a = a-b;
		
		System.out.println("After : " + a + " " + b);
	}

}