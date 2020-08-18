import java.util.*;
import java.io.*;

//1시간 55분 40초
public class Main {
	
	static int N, M, room;
	static int map[][];
	static ArrayList<Camera> list;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		list = new ArrayList<Camera>();	//카메라 정보 담는 리스트
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]%6 != 0)
					list.add(new Camera(i, j, map[i][j]));
				else if(map[i][j] == 0)
					room++;			//빈방 세기
			}
		}
		
		//----입력 끝
		int arr[] = new int[list.size()];
		DFS(0, arr);
		
		System.out.println(min);
	}
	
	static void DFS(int idx, int[] arr)
	{
		if(idx == list.size())
		{
			int tempsum = room;
			int result = shoot(arr, tempsum);
			
			min = Math.min(result, min);
			
			return;
		}
	
		if(list.get(idx).level == 1 || list.get(idx).level == 3 || list.get(idx).level == 4)	//네방향 회전
		{
			arr[idx] = 1;
			DFS(idx+1, arr);
			arr[idx] = 2;
			DFS(idx+1, arr);
			arr[idx] = 3;
			DFS(idx+1, arr);
			arr[idx] = 4;
			DFS(idx+1, arr);
		}
		else if(list.get(idx).level == 2)	//두방향 회전
		{
			arr[idx] = 1;
			DFS(idx+1, arr);
			arr[idx] = 3;
			DFS(idx+1, arr);
		}
		else if(list.get(idx).level == 5)	//그대로
		{
			arr[idx] = 0;	//회전 x
			DFS(idx+1, arr);
		}
	}
	
	static int shoot(int[] cameras, int room){
		//방향 1 : 위쪽, 2: 아래쪽, 3: 왼쪽, 4: 오른쪽
		
		boolean visit[][] = new boolean[N][M];
		
		for(int i=0; i<list.size(); i++)
		{
			Camera c = list.get(i);
			int x = c.x;
			int y = c.y;
			int flag[] = new int[5];	//up, down, left, right
			
			if(c.level == 5)		//모든방향
			{
				flag[1] = flag[2] = flag[3] = flag[4] = 1;
			}
			else if(cameras[i] == 1)
			{
				flag[1] = 1;
				if(c.level >= 3)	flag[4] = 1;
				if(c.level == 4)	flag[3] = 1;
				if(c.level == 2)	flag[2] = 1;
			}
			else if(cameras[i] == 2)
			{
				flag[2] = 1;
				if(c.level >= 3)	flag[3] = 1;
				if(c.level == 4)	flag[4] = 1;
			}
			else if(cameras[i] == 3)
			{
				flag[3] = 1;
				if(c.level >= 3)	flag[1] = 1;
				if(c.level == 4)	flag[2] = 1;
				if(c.level == 2)	flag[4] = 1;
			}
			else if(cameras[i] == 4)
			{
				flag[4] = 1;
				if(c.level >= 3)	flag[2] = 1;
				if(c.level == 4)	flag[1] = 1;
			}
			
			//위
			if(flag[1] == 1)
			{
				for(int j=x; j>=0; j--)
				{
					if(map[j][y] == 6)	break;
					if(visit[j][y] == false && map[j][y] == 0)
					{
						visit[j][y] = true;
						room--;
					}
				}
			}
			//아래
			if(flag[2] == 1)
			{
				for(int j=x; j<N; j++)
				{
					if(map[j][y] == 6)	break;
					if(visit[j][y] == false && map[j][y] == 0)
					{
						visit[j][y] = true;
						room--;
					}
				}
			}
			//왼쪽
			if(flag[3] == 1)
			{
				for(int j=y; j>=0; j--)
				{
					if(map[x][j] == 6)	break;
					if(visit[x][j] == false && map[x][j] == 0)
					{
						visit[x][j] = true;
						room--;
					}
				}
			}
			//오른쪽
			if(flag[4] == 1)
			{
				for(int j=y; j<M; j++)
				{
					if(map[x][j] == 6)	break;
					if(visit[x][j] == false && map[x][j] == 0)
					{
						visit[x][j] = true;
						room--;
					}
				}
			}
		}
		
		return room;
	}
}

class Camera{
	int x;
	int y;
	int level;
	Camera(){};
	Camera(int x, int y, int level)
	{
		this.x = x;
		this.y = y;
		this.level = level;
	}
}
