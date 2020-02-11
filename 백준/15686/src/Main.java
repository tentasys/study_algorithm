import java.io.*;
import java.util.*;

//41분 21초
public class Main {
	
	static int N, M;
	static int map[][];
	static ArrayList<Point> house = new ArrayList<Point>();
	static ArrayList<Point> chicken = new ArrayList<Point>();
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N][N];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				
				//치킨집 리스트와 집 리스트에 추가
				if(map[i][j]==1)		house.add(new Point(i, j));
				else if(map[i][j] == 2)	chicken.add(new Point(i, j));
			}
		}
		//입력 완료
		
		DFS(0, 0, null);
		
		System.out.println(min);
	}

	static void DFS(int idx, int count, int[] dist) {
		
		if(count == M)		//치킨집 다 골랐을 때
		{
			int sum = 0;		
			for(int a : dist)
				sum += a;	
			min = Math.min(min, sum);
			return;
		}
		
		//재귀함수 최초 진입 시
		if(count == 0)
		{
			dist = new int[house.size()];			//집과 치킨집 사이의 거리를 담을 배열
			Arrays.fill(dist, Integer.MAX_VALUE);	//초기화
		}
		
		int temp[] = new int[house.size()];			//거리값 복구를 위해 임시로 저장할 배열
		
		for(int i=idx; i<chicken.size(); i++)
		{
			System.arraycopy(dist, 0, temp, 0, dist.length);	//임시로 배열에 복사
			
			//치킨집과의 최소거리 구하기
			for(int j=0; j<house.size(); j++)
				dist[j] = Math.min(dist[j], distance(house.get(j), chicken.get(i)));	//기존값이 더 가까우면 유지, 아니면 새 값 넣기

			DFS(i+1, count+1, dist);		//재귀함수 진입
			
			System.arraycopy(temp, 0, dist, 0, dist.length);	//다시 원상복귀
		}
	}
	
	static int distance(Point p1, Point p2)		//두점사이 거리구하기
	{
		return (Math.abs(p1.r-p2.r)+Math.abs(p1.c-p2.c));
	}
}

class Point{
	int r;	int c;
	Point(){};
	Point(int r, int c)
	{
		this.r = r;
		this.c = c;
	}
}
