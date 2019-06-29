import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine());
			
			int dp[][] = new int[10][1024];
			for(int i=1; i<10; i++)
				dp[i][1 << i] = 1;
			
			for(int i=1; i<N; i++)
			{
				int temp[][] = new int[10][1024]
			}
			
			System.out.println("#"+ii+" ");
		}
		br.close();
	}

}
