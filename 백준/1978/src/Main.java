import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int count = 0;
		
		for(int i=0; i<N; i++)
		{
			int n = Integer.parseInt(st.nextToken());
			if(isPrime(n) == true)	count++;
		}
		
		System.out.println(count);
		
		br.close();
	}
	
	static boolean isPrime(int n) {
		
		if(n == 1)
			return false;
		if(n == 2)
			return true;
		
		for(int i=2; i*i<=n; i++)		//제곱수 때문에 <= 주의할것
			if(n%i == 0)	return false;
		
		return true;
	}

}
