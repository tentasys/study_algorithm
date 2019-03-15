import java.io.*;
import java.util.PriorityQueue;

public class Main {

	static int arr[][];
	static boolean visit[][];
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//input
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		for(int i=0; i<N; i++)
		{
			String line = br.readLine();
			for(int j=0; j<N; j++)
			{
				if(line.charAt(j) == '0')
					arr[i][j] = 0;
				else
					arr[i][j] = 1;
			}
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
				if(visit[i][j] == false && arr[i][j] == 1)
				{
					count = 0;
					f(i, j, N);
					q.offer(count);
				}
		}
		
		System.out.println(q.size());
		
		while(!q.isEmpty())
			System.out.println(q.poll());
	}
	
	static void f(int i, int j, int N)
	{
		count++;
		visit[i][j] = true;
		int up = i-1;
		int down = i+1;
		int right = j+1;
		int left = j-1;
		
		if(up>=0)
		{
			if(visit[up][j] == false && arr[up][j] == 1)
				f(up, j, N);
		}
		if(down<N)
		{
			if(visit[down][j] == false && arr[down][j] == 1)
				f(down, j, N);
		}
		if(right<N)
		{
			if(visit[i][right] == false && arr[i][right] == 1)
				f(i, right, N);
		}
		if(left>=0)
		{
			if(visit[i][left] == false && arr[i][left] == 1)
				f(i, left, N);
		}
	}

}
