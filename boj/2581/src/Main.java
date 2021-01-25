import java.io.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = -1;
		
		for(int i=M; i<=N; i++) {
			if(isPrime(i) == true) {
				sum += i;
				if(min == -1)	min = i;
				//System.out.println(i);
			}
				
		}
		
		if(sum == 0) {
			System.out.println(-1);
		}		
		else {
			System.out.println(sum);
			System.out.println(min);
		}
			
	}

	public static boolean isPrime(int num) {
		
		if(num == 1)
			return false;
		else if(num == 2)
			return true;
		else {
			for(int i=2; i<= Math.sqrt(num); i++) {
				if(num%i == 0)
					return false;
			}
		}
		
		return true;
	}
}