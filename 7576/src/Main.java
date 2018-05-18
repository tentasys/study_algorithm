import java.io.*;
import java.util.*;

public class Main {

	static int arr[][];
	static int dist[][];

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		dist = new int[N][M];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		//익히기
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				f(i, j);
		
		
		boolean flag = false;
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<M; j++)
			{
				if(arr[i][j] == 0)
				{
					max = -1;
					flag = true;
				}
			}	
			if(flag == true)
				break;
		}
			
		System.out.println(max);
		
		//배열 테스트용
//		for(int i=0; i<N; i++)
//		{
//			for(int j=0; j<M; j++)
//				System.out.print(arr[i][j]);
//			System.out.println();
//		}
	}
	
	static void f(int i, int j)
	{
		
		
	}

}
