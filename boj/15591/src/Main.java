import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int Q = Integer.parseInt(str[1]);
		
		ArrayList<Integer> list[] = new ArrayList[N+1];
		int map[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1; i<N; i++) {
			str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int c = Integer.parseInt(str[2]);
			map[a][b] = map[b][a] = c;
			list[a].add(b);
			list[b].add(a);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int tc=0; tc<Q; tc++) {
			str = br.readLine().split(" ");
			int K = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			
			Queue<Integer> q = new LinkedList<Integer>();
			boolean visit[] = new boolean[N+1];
			
			int ans = 0;
			
			q.add(M);
			visit[M] = true;
			while(!q.isEmpty()) {
				int cur = q.poll();
				
				for(int i : list[cur]) {
					if(visit[i] == true)		continue;
					if(map[cur][i] == 0 || map[cur][i] < K)		continue;
					
					visit[i] = true;
					ans++;
					q.add(i);
				}
			}
			sb.append(ans+"\n");
		}
		
		System.out.println(sb);
	}
}