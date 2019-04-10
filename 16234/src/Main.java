import java.util.*;
import java.io.*;

//1시간 27분
public class Main {

	static int N, L, R;
	static int map[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		//-----------입력 끝
		
		int count = 0;
		while(solution())		//인구이동이 끝날때까지
		{
			count++;
		}
		
		System.out.print(count);
	}

	static boolean solution()	//인구이동 진행
	{
		boolean result = false;
		boolean visit[][] = new boolean[N][N];	//방문 여부를 담을 배열
		int dr[] = {1, -1, 0, 0};
		int dc[] = {0, 0, 1, -1};
		int union[][] = new int[N][N];			//각각의 나라가 어떤 연합에 속해있는지. 0은 무소속
		int member[] = new int[N*N+1];		//각 연합당 한칸에 몇명인지. 1부터 시작! 0은 무소속!
		
		int union_no = 0;
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(visit[i][j] == true)		continue;	//방문한 곳은 가지 않는다
				
				Queue<Point> q = new LinkedList<Point>();	//BFS 진입
				q.offer(new Point(i, j));
				visit[i][j] = true;			//큐는 넣기전에 방문했다고 해야한다
				
				//연합 하나당 큐 한개
				int count = 1;
				int sum = map[i][j];
				union_no++;
				union[i][j] = union_no;
				
				while(!q.isEmpty())
				{
					Point cur = q.poll();
					
					for(int k=0; k<4; k++)		//상하좌우 이동
					{
						int nR = dr[k] + cur.r;
						int nC = dc[k] + cur.c;
						
						if(nR < 0 || nR >= N || nC < 0 || nC >= N)		//도달 가능한 범위가 아니면 패스
							continue;
						if(diff(cur, nR, nC)<L || diff(cur, nR, nC)>R)	//L명이상 R명이하가 아니면 패스
							continue;
						if(visit[nR][nC] == true)			//이미 방문한 곳은 가지 않는다
							continue;
						
						//연합 가능한 상태
						result = true;
						visit[nR][nC] = true;		//이동
						q.offer(new Point(nR, nC));
						count++;
						sum += map[nR][nC];
						union[nR][nC] = union_no;
					}
				}//연합 끝
				
				member[union_no] = sum/count;		//각 연합의 인구 수
			}//--칸마다 체크하는 반복문
		}
		
		//인구 정보 업데이트
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(union[i][j] != 0)
					map[i][j] = member[union[i][j]];
			}
		}
			
		return result;
	}

	static int diff(Point p, int r, int c)		//두 지역 인구차
	{
		return Math.abs(map[p.r][p.c]-map[r][c]);
	}
}
class Point{
	int r, c;
	Point(){};
	Point(int r, int c)
	{
		this.r = r;		this.c = c;
	}
}
