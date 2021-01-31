import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean isPrime[] = new boolean[1000001];
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<isPrime.length; i++)
			isPrime[i] = true;
		
		isPrime[0] = false;
		isPrime[1] = false;		
		
		for(int i=2; i<=N; i++)
		{
			if(isPrime[i] == true) {
				if(i >= M)	sb.append(i+"\n");
				
				int cal = 2;
				while(i*cal <= 1000000) {
					isPrime[i*cal] = false;
					cal++;
				}
			}
		}
		
		System.out.println(sb);
	}
}