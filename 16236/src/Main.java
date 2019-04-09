import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int map[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];			//정보를 담고 있는 지도
		Baby_Shark shark = null;		//아~기~상어~뚜루뚜뚜뚜~
		ArrayList<Fish> fish = new ArrayList<Fish>();
		
		//입력 받기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 9)						//아기상어 만나면
				{
					shark = new Baby_Shark(i, j, 2, 0);//상어 만들기
					map[i][j] = 0;						//다시 돌아와야하므로 0으로 만들기
				}
				else if(map[i][j] != 0)		fish.add(new Fish(i, j, map[i][j]));	//물고기 리스트에 추가
			}
		}
		//----입력 끝
		
		int time = 0;		//얼마만에 도움을 청하는가
		
		//찾으면서 먹게 할 수 있음!
		for(int i=0; i<fish.size(); i++)		//총 먹을 물고기 수만큼 뺑이
		{
			int min_distance = 401;			//최대 크기는 20x20이므로 400을 넘을 수 없다
			Fish min_fish = fish.get(0);	//최소거리를 가진 고기 정보
			
			for(int j=0; j<fish.size(); j++)
			{
				if(fish.get(j).isAlive() == false || fish.get(j).size >= shark.size)	//죽었거나 큰고기는 건너뜀
					continue;
				
				int temp;
				
				temp = distance(fish.get(j), shark);	//고기와의 거리 구하기
				if(temp == -1)	continue;	//갈 수 없는 경우
				else
				{
					//가장 가까운거 정하기
					if(temp < min_distance)	//거리가 작으면
					{
						min_distance = temp;
						min_fish = fish.get(j);
					}
					else if(temp == min_distance)	//거리가 같은 경우
					{
						if(fish.get(j).x < min_fish.x)		//위쪽에 있으면
						{
							min_distance = temp;
							min_fish = fish.get(j);
						}
						else if(fish.get(j).x == min_fish.x)	//높이가 같은 경우
						{
							if(fish.get(j).y < min_fish.y)		//왼쪽에 있으면
							{
								min_distance = temp;
								min_fish = fish.get(j);
							}
						}
					}
				}//가까운거 정하기 끝
			}
			
			//먹을 고기 정하기
			if(min_distance < 401)
			{
				time += min_distance;			//시간에 거리 더하기
				min_fish.alive = false;
				shark.level_up(1);
				shark.x = min_fish.x;
				shark.y = min_fish.y;
				map[min_fish.x][min_fish.y] = 0;
			}
		}
		
		System.out.print(time);
	}
	
	//최소거리 찾기
	static public int distance(Fish fish, Baby_Shark shark)
	{	
		Queue<Fish> q = new LinkedList<Fish>();
		q.offer(new Fish(shark.x, shark.y, 0));		//상어 이동하자
		
		int dist[][] = new int[N][N];
		boolean visit[][] = new boolean[N][N];
		int min = Integer.MAX_VALUE;
		
		//BFS에서 큐에 넣을 때 visit을 해 줘야지 중복방문을 하지 않는다
		while(!q.isEmpty())
		{
			Fish temp = q.poll();
			
			//상
			if(temp.x > 0)
			{
				if(map[temp.x-1][temp.y] <= shark.size && visit[temp.x-1][temp.y] == false)
				{
					visit[temp.x-1][temp.y] = true;
					q.offer(new Fish(temp.x-1, temp.y, 0));
					dist[temp.x-1][temp.y] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x-1 == fish.x && temp.y == fish.y)	min = Math.min(min, dist[temp.x-1][temp.y]);
				}
			}
			//하
			if(temp.x < N-1)
			{
				if(map[temp.x+1][temp.y] <= shark.size && visit[temp.x+1][temp.y] == false)
				{
					visit[temp.x+1][temp.y] = true;
					q.offer(new Fish(temp.x+1, temp.y, 0));
					dist[temp.x+1][temp.y] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x+1 == fish.x && temp.y == fish.y)	min = Math.min(min, dist[temp.x+1][temp.y]);
				}
			}
			//좌
			if(temp.y > 0)
			{
				if(map[temp.x][temp.y-1] <= shark.size && visit[temp.x][temp.y-1] == false)
				{
					visit[temp.x][temp.y-1] = true;
					q.offer(new Fish(temp.x, temp.y-1, 0));
					dist[temp.x][temp.y-1] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x == fish.x && temp.y-1 == fish.y)	min = Math.min(min, dist[temp.x][temp.y-1]);
				}
			}
			//우
			if(temp.y < N-1)
			{
				if(map[temp.x][temp.y+1] <= shark.size && visit[temp.x][temp.y+1] == false)
				{
					visit[temp.x][temp.y+1] = true;
					q.offer(new Fish(temp.x, temp.y+1, 0));
					dist[temp.x][temp.y+1] =  dist[temp.x][temp.y] + 1;
					
					if(temp.x == fish.x && temp.y+1 == fish.y)	min = Math.min(min, dist[temp.x][temp.y+1]);
				}
			}
		}
		
		if(dist[fish.x][fish.y] == 0)	return -1;
		else							return min;
	}
}

//잡아먹을 물고기들
class Fish{
	int x;	int y;	int size;	boolean alive;
	Fish(){};
	Fish(int x, int y, int size)
	{
		this.x = x;		this.y = y;		this.size = size;	this.alive = true;
	}
	public boolean isAlive()
	{
		if(this.alive == true)	return true;
		else	return false;
	}
}

//아기 상어
class Baby_Shark{
	int x;	int y;	int size;	int count;
	Baby_Shark(){};
	Baby_Shark(int x, int y, int size, int count)
	{
		this.x = x;		this.y = y;		this.size = size;	this.count = count;
	}
	
	//몇 번 먹으면 레벨업하나
	public void level_up(int n) {
		int sum = n + this.count;
		
		if(sum/this.size > 0)
		{
			this.size++;
			this.count = 0;
		}
		else
			this.count += n;
	}
}