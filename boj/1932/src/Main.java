import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
//
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[][] = new int[n][];
		int sum[][] = new int[n][];
		
		for(int i=0; i<n; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new int[i+1];
			sum[i] = new int[i+1];
			
			for(int j=0; j<=i; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		sum[0][0] = arr[0][0];
		
		for(int i=1; i<n; i++)
		{
			sum[i][0] = sum[i-1][0]+arr[i][0];
			sum[i][i] = sum[i-1][i-1]+arr[i][i];
			
			for(int j=1; j<i; j++)
				sum[i][j] = Math.max(sum[i-1][j-1], sum[i-1][j])+arr[i][j];
		}
		
		int max = 0;
		for(int i=0; i<n; i++)
			max = Math.max(max, sum[n-1][i]);
		
		System.out.println(max);
	}

}
