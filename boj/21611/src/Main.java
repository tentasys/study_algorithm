import java.util.*;
import java.io.*;

public class Main {

//	상하좌우 
	static final int dr[] = {0, -1, 1, 0, 0}; 
	static final int dc[] = {0, 0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());		//격자 크기 
		int M = Integer.parseInt(st.nextToken());		//블리자드 시전 횟수 
		
		Node idxarr[] = createIdx(N);					//r, c 별로 인덱스로 관리 
		int map[][] = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int bomb_cnt[] = new int[4];					//폭발한 구슬의 갯수 
		
		//마법 횟수별로 진행 
		for(int tc=0; tc<M; tc++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()); 	//마법의 방향 
			int s = Integer.parseInt(st.nextToken());	//마법의 거리 
			
			//1단계 : 블리자드 
			for(int i=1; i<=s; i++) {
				int r = idxarr[0].r + dr[d]*i;
				int c = idxarr[0].c + dc[d]*i;
				
				map[r][c] = 0;
			}
			
//			printmap(map, N, "블리자드 ");
			
			//2단계 : 이동 및 폭발 
			while(true) {
				//빈칸에 구슬 채우기 
				//이슈 1 : 구슬 채우는데 속도가 너무 오래 걸려서 시간초과가 남 
//				for(int i=2; i<N*N; i++) {
//					Node cur = idxarr[i];
//					//0 만날 때 까지 옮긴다 
//					for(int j=i; j>=2; j--) {
//						Node prev = idxarr[j-1];
//						if(map[prev.r][prev.c] == 0) {
//							map[prev.r][prev.c] = map[cur.r][cur.c];
//							map[cur.r][cur.c] = 0;
//							cur = prev;
//						}
//						else
//							break;
//					}
//				}
				ArrayList<Integer> fill = new ArrayList<Integer>();
				fill.add(0);
				for(int i=1; i<N*N; i++) {
					Node cur = idxarr[i];
					if(map[cur.r][cur.c] != 0)
						fill.add(map[cur.r][cur.c]);
				}
				for(int i=0; i<N*N; i++) {
					Node cur = idxarr[i];
					if(i >= fill.size())
						map[cur.r][cur.c] = 0;
					else
						map[cur.r][cur.c] = fill.get(i);
				}
				
//				printmap(map, N, "구슬 끌어오기 ");
				//4칸 이상 연속 폭발 
				ArrayList<ArrayList<Node>> bomb_list = new ArrayList<ArrayList<Node>>();
				ArrayList<Node> temp_list = new ArrayList<Node>();
				int prev = map[idxarr[1].r][idxarr[1].c];
				temp_list.add(idxarr[1]);
				
				for(int i=2; i<N*N; i++) {
					int cur = map[idxarr[i].r][idxarr[i].c];
					if(cur == 0)	continue;
					if(prev == cur) {
						temp_list.add(idxarr[i]);
						
						if(temp_list.size() == 4)
							bomb_list.add(temp_list);
					}
					else {
						prev = cur;
						temp_list = new ArrayList<Node>();
						temp_list.add(idxarr[i]);
					}
				}
				
				if(bomb_list.size() == 0)	break; 	//폭발한 구슬이 없다면 탈출 
				
				//구슬 폭발 
				for(ArrayList<Node> list : bomb_list) {
					for(Node cur : list) {
						bomb_cnt[map[cur.r][cur.c]]++;
						map[cur.r][cur.c] = 0;
					}
				}
				
//				printmap(map, N, "구슬 폭발 ");
			}
			
			
			//3단계 : 구슬 변화 
			ArrayList<Integer> new_list = new ArrayList<Integer>();
			new_list.add(0);			//인덱스 관리를 위한 상어 
			Node prev = idxarr[1];
			int cnt = 1;
			for(int i=2; i<N*N; i++) {
				Node cur = idxarr[i];
				if(map[cur.r][cur.c] == 0)	break;
				if(map[cur.r][cur.c] != map[prev.r][prev.c]) {
					new_list.add(cnt);		//구슬의 개수 
					new_list.add(map[prev.r][prev.c]); 		//구슬의 번호 
					cnt = 1;
					prev = cur;
				}
				else	cnt++;
			}
			
			//이슈 2 : 변화한 구슬이 없을 때으 ㅣ처리가 안 됨 
			if(new_list.size() != 1) {
				new_list.add(cnt);
				new_list.add(map[prev.r][prev.c]);
			}
			
			
			for(int i=1; i<N*N; i++) {
				if(i >= new_list.size())	break;
				Node cur = idxarr[i];
				map[cur.r][cur.c] = new_list.get(i);
			}
			
//			printmap(map, N, "블리자드 끝 ");
		}
		System.out.println(bomb_cnt[1]+2*bomb_cnt[2]+3*bomb_cnt[3]);
		
		br.close();
	}

	//인덱스 배열 
	static Node[] createIdx(int N) {
		Node[] idxarr = new Node[N*N];
		int num = N*N-1;
		int dir = 4;
		
		int map[][] = new int[N+1][N+1];
		
		int r = 1;
		int c = 1;
		while(num >= 0) {
			map[r][c] = num;
			idxarr[num] = new Node(r, c);
			
			int nr = r+dr[dir];
			int nc = c+dc[dir];
			
			boolean rotateflag = false;
			if(nr > N || nc > N || nr < 1 || nc < 1)
				rotateflag = true;
			else if(map[nr][nc] != 0)
				rotateflag = true;
			
			if(rotateflag == true) {
				dir = rotate(dir);
				nr = r+dr[dir];
				nc = c+dc[dir];
			}
			
			r = nr;
			c = nc;
			num--;
		}
		
		return idxarr;
	}
	
	static int rotate(int dir) {
		switch(dir) {
		case 1: return 4;
		case 2: return 3;
		case 3: return 1;
		case 4:	return 2;
		default:
			return dir;
		}
	}
	
	static void printmap(int[][] map, int N, String msg) {
		System.out.println("-------- "+msg+" --------");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				System.out.print(map[i][j]+"\t");
			System.out.println();
		}
		System.out.println();
	}
}

class Node{
	int r;	int c;
	Node(int r, int c){
		this.r = r;
		this.c = c;
	}
}