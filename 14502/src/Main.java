import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int map[][];
	static int max = 0;
	static ArrayList<Point> zero_list = new ArrayList<Point>();		//벽으로 가능한 점의 리스트들
	static ArrayList<Combi> combination = new ArrayList<Combi>();	//조합을 담을 리스트
	static int test = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
			
		//입력받는것
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zero_list.add(new Point(i, j));		//0이면 벽을 세울 수 있다
			}
		}
		
		//조합 리스트 구하기
		Combination(0, 0, null);
		
		//조합 리스트에서 BFS 수행
		for(Combi c : combination)
		{
			map[c.p1.r][c.p1.c] = 1;
			map[c.p2.r][c.p2.c] = 1;
			map[c.p3.r][c.p3.c] = 1;
			
			boolean visit[][] = new boolean[N][M];
			int temp_max = zero_list.size()-3;				//벽 3개 세우면 이만큼의 넓이임
			Queue<Point> q = new LinkedList<Point>();		//BFS 큐
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(map[i][j] == 2 && visit[i][j] == false)		//바이러스가 있는 칸의 값을 감소시키자
					{
						//BFS로 탐색하며 2가 갈수있는 최대거리를 구하기
						q.offer(new Point(i, j));
						while(!q.isEmpty())
						{
							Point temp = q.poll();
							if(visit[temp.r][temp.c] == true)	continue;
							
							visit[temp.r][temp.c] = true;	//방문 표시
							if(map[temp.r][temp.c] == 0)
								temp_max--;						//넓이 감소
							
							//2 돌아다니기
							if(temp.r > 0)		//상
								if(map[temp.r-1][temp.c] != 1 && visit[temp.r-1][temp.c] == false)
									q.offer(new Point(temp.r-1, temp.c));
							if(temp.c > 0)		//좌
								if(map[temp.r][temp.c-1] != 1 && visit[temp.r][temp.c-1] == false)
									q.offer(new Point(temp.r, temp.c-1));
							if(temp.r < N-1)	//하
								if(map[temp.r+1][temp.c] != 1 && visit[temp.r+1][temp.c] == false)
									q.offer(new Point(temp.r+1, temp.c));
							if(temp.c < M-1)	//우
								if(map[temp.r][temp.c+1] != 1 && visit[temp.r][temp.c+1] == false)
									q.offer(new Point(temp.r, temp.c+1));
						}
					}
				}
			}
			
			max = Math.max(max, temp_max);
			
			map[c.p1.r][c.p1.c] = 0;
			map[c.p2.r][c.p2.c] = 0;
			map[c.p3.r][c.p3.c] = 0;
		}
		
		System.out.println(max);
	}
	
	static void Combination(int idx, int count, int[] temp_list)
	{
		if(count == 3)		//3개 다 골랐을 때
		{
			Point temp1 = new Point(zero_list.get(temp_list[0]).r, zero_list.get(temp_list[0]).c);
			Point temp2 = new Point(zero_list.get(temp_list[1]).r, zero_list.get(temp_list[1]).c);
			Point temp3 = new Point(zero_list.get(temp_list[2]).r, zero_list.get(temp_list[2]).c);
			
			Combi temp = new Combi(temp1, temp2, temp3);
			combination.add(temp);
			return;
		}
		if(count == 0)		//처음일 때
			temp_list = new int[3];		//조합에서 고른 인덱스 저장
		
		for(int i=idx; i<zero_list.size(); i++)
		{
			temp_list[count] = i;
			Combination(i+1, count+1, temp_list);
		}
	}
}

class Point{
	int r;
	int c;
	Point(){};
	Point(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
}

class Combi{
	Point p1;
	Point p2;
	Point p3;
	Combi(){};
	Combi(Point p1, Point p2, Point p3){
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
	};
}