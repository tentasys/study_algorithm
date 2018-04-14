import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;
	static int num[];
	static int N;
	
	public static void main(String[] args) throws Exception{
		//https://www.swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeRZV6kBUDFAVH
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int ii=0; ii<T; ii++)
		{
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			
			int op[] = new int[4];
			for(int i=0; i<4; i++)
				op[i] = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			num = new int[N];
			for(int i=0; i<N; i++)
				num[i] = Integer.parseInt(st.nextToken());
			
			int cal[] = new int[N-1];
			f(cal, op[0], op[1], op[2], op[3], 1);
			
			System.out.println("#" + (ii+1) + " " + (max-min));
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
		}//end of each TC
	}

	static void f(int cal[], int plus, int minus, int mul, int div, int d)
	{
		if(d == N)
		{
			int result = num[0];
			
			for(int i=1; i<N; i++)
			{
				if(cal[i-1] == 0)
					result += num[i];
				else if(cal[i-1] == 1)
					result -= num[i];
				else if(cal[i-1] == 2)
					result *= num[i];
				else
					result /= num[i];
			}
			
			if(min > result)	min = result;
			if(max < result)	max = result;
			
			return;
		}
		if(plus > 0)
		{
			cal[d-1] = 0;
			f(cal, plus-1, minus, mul, div, d+1);
		}
		if(minus > 0)
		{
			cal[d-1] = 1;
			f(cal, plus, minus-1, mul, div, d+1);
		}
		if(mul > 0)
		{
			cal[d-1] = 2;
			f(cal, plus, minus, mul-1, div, d+1);
		}
		if(div > 0 && (num[d] != 0))
		{
			cal[d-1] = 3;
			f(cal, plus, minus, mul, div-1, d+1);
		}
	}
}
