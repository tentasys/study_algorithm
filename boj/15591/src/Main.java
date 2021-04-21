import java.io.*;
public class Main {

	//간선의 비용이 가장 작은 것부터 찾는 알고리즘 
	static int map[][];
	static int arr[][];
	static boolean visit[][];
	static boolean connect[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int Q = Integer.parseInt(str[1]);
		
		map = new int[N+1][N+1];
		visit = new boolean[N+1][N+1];
		connect = new boolean[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}		
		
		for(int i=1; i<N; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			map[a][b] = c;
			map[b][a] = c;
			connect[a][b] = connect[b][a] = true;
		}
		
		//거리 구하기 
//		for(int i=1; i<=N; i++) {
//			for(int j=1; j<=N; j++) {
//				for(int k=1; k<=N; k++) {
//					if(j == k)  continue;
//					//j->i, i->k 확인 
//					if(arr[j][i] == -1 || arr[i][k] == -1)
//						continue;
//					map[j][k] = Math.min(map[j][k], Math.min(map[j][i], map[i][k]));
//				}
//			}
//		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<Q; i++) {
			str = br.readLine().split(" ");
			int K = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			int count = 0;
			for(int j=1; j<=N; j++) {
				if(map[M][j] >= K && j != M)
					count++;
			}
			
			sb.append(count+"\n");
		}
		
		
		System.out.println(sb);
	}

	static void go(int N, int start, int min) {
		for(int i=1; i<=N; i++) {
			if(connect[start][i] == false)	continue;
			if(visit[start][i] == true)		continue;
			
			
		}
	
	}
}
