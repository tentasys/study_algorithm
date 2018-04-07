import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] matrix = new int[1001][1001];
	static int[] visit = new int[1001];
	static int[] visit2 = new int[1001];
	static int[] arr = new int[3];
	
	public static void main(String arg[]) throws NumberFormatException, IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//초기 환경 설정
		for(int i=0; i<3; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		//arr[0] : 정점의 개수, arr[1] : 간선의 개수, arr[2] : 탐색을 시작할 정점 번호
		
		for(int i=0; i<arr[1]; i++)
		{
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			matrix[a][b] = matrix[b][a] = 1;
		}

		DFS(arr[2]);
		System.out.print("\n");
		BFS(arr[2]);
	}
	
	public static void DFS(int n) {
		visit[n] = 1;
		System.out.print(n + " ");
		
		for(int i=1; i<=arr[0]; i++)
		{
			if((matrix[n][i] == 1) && (visit[i] != 1))
				DFS(i);
		}
	}
	
	public static void BFS(int n) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		int a = n;
		q.offer(a);
		visit2[a] = 1;
		
		while(!q.isEmpty()) {
			a = q.poll();
			for(int i=1; i<=arr[0]; i++)
			{
				if((matrix[a][i] == 1) && (visit2[i] != 1))
				{
					q.offer(i);
					visit2[i] = 1;
				}	
			}
			System.out.print(a + " ");
		}
	}	
}
