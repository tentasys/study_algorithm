//1시간 12분 

import java.io.*;
import java.util.*;


public class Main {

	//0, ←(1), ↖(2), ↑(3), ↗(4), →(5), ↘(6), ↓(7), ↙(8) 
	static final int dr[] = {0, 0, -1, -1, -1, 0, 1, 1, 1};
	static final int dc[] = {0, -1, -1, 0, 1, 1, 1, 0, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
	
		int map[][] = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// ------ 초기화 끝 ------ 
		
		ArrayList<Node> clouds = new ArrayList<Node>();	//구름 리스트 
		clouds.add(new Node(N, 1));
		clouds.add(new Node(N, 2));
		clouds.add(new Node(N-1, 1));
		clouds.add(new Node(N-1, 2));
		
		
		for(int tc=0; tc<M; tc++) {
			
			//1. 구름 이동 
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());		//방향 
			int gap = Integer.parseInt(st.nextToken());		//이동거리 
			boolean visit[][] = new boolean[N+1][N+1];		//옮긴 구름의 자리 == 사라질 구름의 자리 
			
			for(Node cur : clouds) {
				cur.move(dr[dir], dc[dir], gap, N);
				visit[cur.r][cur.c] = true;
				
				//2. 비 내리기 
				map[cur.r][cur.c]++;
			}
			
			//3. 물복사 버그 
			for(Node cur : clouds) {
				int cnt = 0;
				for(int i=2; i<=8; i+=2) {	//대각선 탐지 
					int nr = cur.r + dr[i];
					int nc = cur.c + dc[i];
					
					if(nr > N || nc > N || nr < 1 || nc < 1)	continue;
					if(map[nr][nc] < 1)		continue;
					
					cnt++;
				}
				map[cur.r][cur.c] += cnt;
			}
			
			//4. 구름 생성 
			clouds = new ArrayList<Node>();	//구름 리스트 초기화 
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(visit[i][j] == true)		continue;	//이전에 구름이 있던 자리면 지나감 
					if(map[i][j] < 2)			continue;	//물 양이 2 미만이면 지나감 
					
					clouds.add(new Node(i, j));
					map[i][j] -= 2;
				}
			}
		}
		
		//결과 카운트 
		int result = 0;
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				result += map[i][j];
		}
		
		System.out.println(result);
	}

}

class Node{
	int r;	int c;
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
	
	public void move(int dr, int dc, int gap, int N) {
		int nr = r + dr*(gap%N);
		int nc = c + dc*(gap%N);
		
		if(nr > N)		nr -= N;
		else if(nr < 1)	nr += N;
		
		if(nc > N)		nc -= N;
		else if(nc < 1)	nc += N;
		
		this.r = nr;
		this.c = nc;
	}
}