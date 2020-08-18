import java.util.*;
import java.io.*;

public class Main {

	static int arr[][];
	static int visit[];
	static int N;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		visit = new int[N+1];
		int count = 0;
		
		//배열 초기화
		for(int i=0; i<E; i++)
		{
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x][y] = arr[y][x] = 1;
		}
		
		//회로 개수 찾기
		for(int i=1; i<N+1; i++)
			if(DFS(i) == 1)	count++;
		
		System.out.println(count);
		br.close();
	}
	
	static int DFS(int n) {
		
		if(visit[n] == 1)	return 0;
		visit[n] = 1;
		
		for(int i=1; i<N+1; i++)
		{
			if(visit[i] == 0 && arr[n][i] == 1)
				DFS(i);
		}
		
		return 1;
	}

}
