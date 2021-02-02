import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int fibonacci[] = {0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181,6765};
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci[n]);
	}
	
	//피보나치 재귀 함수 
//	public static int fibonacci(int n) {
//		if(n == 0)
//			return 0;
//		else if(n == 1)
//			return 1;
//		else if(n == 2)
//			return 1;
//		else
//			return fibonacci(n-1) + fibonacci(n-2);
//	}
}