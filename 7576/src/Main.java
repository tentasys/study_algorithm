import java.io.*;
import java.util.*;

public class Main {

	static int arr[][];
	static int dist[][];
	static boolean visit[][];
	static int N, M;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		visit = new boolean[N][M];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		
		//익히기
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(arr[i][j] == 1)
				{
					for(int k=0; k<N; k++)
						Arrays.fill(visit[k], false);
					
					f(i, j, 0);
					if(min > max)
						min = max;
				}	
			}
		}
			
//		System.out.println(min);
		
		//배열 테스트용
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
				System.out.print(dist[i][j]);
			System.out.println();
		}
	}
	
	static void f(int i, int j, int d)
	{
		
		for(int ii=0; ii<N; ii++)
		{
			for(int jj=0; jj<M; jj++)
				System.out.print(dist[ii][jj] + " ");
			System.out.println();
		}
		System.out.println();
		System.out.println(i + " " + j);
		visit[i][j] = true;
		dist[i][j] = d;
		
		if(max < d)
			max = d;
		
		int up = i-1;	int down = i+1;	int left = j-1;	int right = j+1;
		
		if(up >= 0)
		{
			if((visit[up][j] == false || dist[up][j] > dist[i][j]+1) && arr[up][j] == 0)
				f(up, j, d+1);
		}
		if(down < N)
		{
			if((visit[down][j] == false || dist[down][j] > dist[i][j]+1) && arr[down][j] == 0)
				f(down, j, d+1);
		}
		if(left >= 0)
		{
			if((visit[i][left] == false || dist[i][left] > dist[i][j]+1) && arr[i][left] == 0)
				f(i, left, d+1);
		}
		if(right < M)
		{
			if((visit[i][right] == false || dist[i][right] > dist[i][j]+1) && arr[i][right] == 0)
				f(i, right, d+1);
		}
	}

}
