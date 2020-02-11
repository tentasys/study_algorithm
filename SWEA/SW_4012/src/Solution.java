import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int S[][];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for(int ii=0; ii<T; ii++)
		{
			N = Integer.parseInt(br.readLine());
			S = new int[N][N];	
			
			//input
			for(int i=0; i<N; i++)
			{
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
					S[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0; i<N; i++)
			{
				for(int j=i; j<N; j++)
					S[i][j] += S[j][i];
			}
			
			int arr_a[] = new int[N/2];
			int arr_b[] = new int[N/2];
			f(arr_a, arr_b, 1, N/2, N/2, 0);
			
			System.out.println("#" + (ii+1) + " " + min);
			
			min = Integer.MAX_VALUE;
		}//end of each TC

	}
	
	//a:0 b:1, a : acount, b: bcount
	static void f(int arr_a[], int arr_b[], int d, int a, int b, int flag)
	{
		if(flag == 0)
		{
			arr_a[N/2-a] = d;
			a--;
		}
		else
		{
			arr_b[N/2-b] = d;
			b--;
		}
			
		if(d == N)
		{
			int sum_a = 0;
			int sum_b = 0;
			
			for(int i=0; i<N/2-1; i++)
			{
				for(int j=i+1; j<N/2; j++)
				{
					sum_a += S[arr_a[i]-1][arr_a[j]-1];
					sum_b += S[arr_b[i]-1][arr_b[j]-1];
				}
			}

			if(min > Math.abs(sum_b-sum_a))
				min = Math.abs(sum_b-sum_a);
			
			return;
		}
		if(a>0)
			f(arr_a, arr_b, d+1, a, b, 0);		
		if(b>0)
			f(arr_a, arr_b, d+1, a, b, 1);	
	}
}
