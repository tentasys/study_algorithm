import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long dp[] = new long[10];
		
		for(int i=1; i<10; i++)
			dp[i] = 1;
		
		for(int i=1; i<N; i++)
		{
			long temp[] = new long[10];	//복사를 위한 임시 배열
			
			temp[0] = dp[1]%1000000000;
			temp[1] = (dp[0]+dp[2])%1000000000;
			temp[2] = (dp[1]+dp[3])%1000000000;
			temp[3] = (dp[2]+dp[4])%1000000000;
			temp[4] = (dp[3]+dp[5])%1000000000;
			temp[5] = (dp[4]+dp[6])%1000000000;
			temp[6] = (dp[5]+dp[7])%1000000000;
			temp[7] = (dp[6]+dp[8])%1000000000;
			temp[8] = (dp[7]+dp[9])%1000000000;
			temp[9] = dp[8]%1000000000;
			
			dp = temp;
		}
		
		long sum = 0;
		for(int i=0; i<10; i++)
			sum += dp[i];
		
		System.out.print(sum%1000000000);
	}
}