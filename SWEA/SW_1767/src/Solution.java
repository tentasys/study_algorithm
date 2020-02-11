import java.util.*;
import java.io.*;
import java.awt.Point;

public class Solution {

	static int min;
	static final int dr[] = {-1, 1, 0, 0};	//상하좌우
	static final int dc[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int ii=1; ii<=T; ii++)
		{
			int N = Integer.parseInt(br.readLine().trim());
			int map[][] = new int[N][N];
			ArrayList<Point> list = new ArrayList<Point>();
			
			for(int i=0; i<N; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
					{
						if(i == 0 || j == 0 || i == N-1 || j == N-1)	//벽에 붙어있을 경우 연결하지 않는다
							continue;
						
						list.add(new Point(i, j));			//관리할 리스트에 추가
					}
				}
			}
			
			min = Integer.MAX_VALUE;
			
			go(list, map, new boolean[N][N], list.size(), 0, 0, N);
			
			System.out.println("#"+ii+" "+min);
		}
		
		br.close();
	}

	public static void go(ArrayList<Point> list, int map[][], boolean visit[][], int size, int count, int sum, int N)
	{
		if(count == size)
		{
			min = Math.min(min, sum);
			return;
		}
		
		for(int i=0; i<4; i++)
		{
			Point cur = list.get(count);
			int r = cur.x;
			int c = cur.y;
			int temp_sum = 0;
			
			while(r >= 0 && c >= 0 && r < N && c < N)
			{
				r += dr[i];
				c += dc[i];
				
				if(r < 0 || c < 0 || r >= N || c >= N)
					break;
				if(map[r][c] == 1)
					break;
				if(visit[r][c] == true)
					break;
				
				temp_sum++;
				visit[r][c] = true;
			}
			
			if(sum+temp_sum >= min)
				return;
			
			go(list, map, visit, size, count+1, sum+temp_sum, N);
		}
	}
}
