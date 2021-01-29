import java.io.*;
public class Main {

	public static boolean prime[] = new boolean[10001];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		setPrime();
		
		
		for(int tc=0; tc<T; tc++) {
			int n = Integer.parseInt(br.readLine());
			int x = 1;
			int y = n-x;
			
			for(int i=n/2; i>=2; i--) {
				x = i;
				y = n-x;
				
				if(prime[x] == true && prime[y] == true)
					break;
			}
			
			System.out.println(x+" "+y);
		}
	}
	
	public static void setPrime() {
		prime[0] = false;
		prime[1] = false;
		prime[2] = true;
		
		for(int i=3; i<=10000; i++) {
			boolean isprime = true;
			
			for(int j=2; j<=Math.sqrt(i); j++) {
				if(i%j == 0) {
					isprime = false;
					break;
				}
			}
			
			prime[i] = isprime;
		}
	}
}