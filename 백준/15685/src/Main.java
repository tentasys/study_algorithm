import java.util.*;
import java.io.*;

//59분 57초
public class Main {

	static int map[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		//-----입력받기
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101]; 
		
		int x[] = new int[N];
		int y[] = new int[N];
		int d[] = new int[N];
		int g[] = new int[N];
		
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
			g[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		//-----입력받기 끝
		
		//각 회차별 드래곤커브 수행
		for(int i=0; i<N; i++)
		{
			//드래곤 커브의 선분
			ArrayList<Point> dragon = new ArrayList<Point>();
			
			int initial_x = x[i];
			int initial_y = y[i];
			dragon.add(new Point(initial_x, initial_y));
			
			//0세대 드래곤 커브를 위한 이동
			int second_x = initial_x;
			int second_y = initial_y;
			
			if(d[i] == 0)		//x좌표 증가, 오른쪽
				second_x++;
			else if(d[i] == 1)	//y좌표 감소, 위쪽
				second_y--;
			else if(d[i] == 2)	//x좌표 감소, 왼쪽
				second_x--;
			else	//(d[i] == 3), y좌표가 증가하는 방향, 아래쪽
				second_y++;
			
			dragon.add(new Point(second_x, second_y));
			
			//세대별 드래곤 커브 구하기
			for(int j=0; j<g[i]; j++)
			{
				//드래곤 커브의 마지막에 있는 좌표 구하기
				int start_x = dragon.get(dragon.size()-1).x;
				int start_y = dragon.get(dragon.size()-1).y;
				
				//마지막 좌표를 0으로 만드는 값 구하기
				int make_zero_x = start_x*(-1);
				int make_zero_y = start_y*(-1);
				
				//새로 추가할 리스트 구하기
				ArrayList<Point> newList = new ArrayList<Point>();
				
				//현재 드래곤 커브를 돌면서 이동하기
				for(int k = dragon.size()-1; k>=0; k--)
				{
					int new_x = (dragon.get(k).y+make_zero_y)*(-1)-make_zero_x;
					int new_y = dragon.get(k).x+make_zero_x-make_zero_y;
					newList.add(new Point(new_x, new_y));
				}
				
				//새로 추가할 리스트를 본 리스트에 추가하기
				for(Point p : newList)
					dragon.add(new Point(p.x, p.y));
			}
			
			//구한 드래곤 커브를 격자에 찍기
			for(Point p: dragon)
				map[p.x][p.y] = 1;
		}
		
		//드래곤 커브를 꼭지점으로 하는 사각형 구하기
		int result = 0;
		for(int i=0; i<100; i++)
		{
			for(int j=0; j<100; j++)
			{
				if(map[i][j] == 0)
					continue;
				if(map[i+1][j] == 0)
					continue;
				if(map[i][j+1] == 0)
					continue;
				if(map[i+1][j+1] == 0)
					continue;
				result++;
			}
		}
		
		System.out.print(result);
	}
}

class Point{
	int x;
	int y;
	Point(){};
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
}
