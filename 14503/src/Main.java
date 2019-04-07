import java.io.*;
import java.util.*;

//2시간 20분
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//첫째줄 입력받기
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int arr[][] = new int[N][M];
		
		//둘째줄 입력받기
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int direction = Integer.parseInt(st.nextToken());		//0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽
		
		//칸 초기화하기
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int count = 0;
		
		while(true)
		{	
			if(arr[r][c] == 0)		//후진한걸 대비
			{
				arr[r][c] = -1;		//현재자리 청소
				count++;			//횟수 증가
			}
			
			Point next = direction_point(r, c, (direction+3)%4);	//다음 갈 곳 찾기
			
			if(arr[next.r][next.c] == 0)	//다음 곳 청소해야한다
			{
				r = next.r;
				c = next.c;
				direction = (direction+3)%4;	//회전
				continue;
			}
			
			int i;
			//다음 곳을 갈 수 없다면 방향 회전
			for(i=0; i<3; i++)
			{
				direction = (direction+3)%4;	//일단 회전
				next = direction_point(r, c, (direction+3)%4);	//회전한 방향의 왼쪽 찾기
				
				if(arr[next.r][next.c] == 0)	//회전한 방향의 왼쪽이 비어있으면 이동
				{
					r = next.r;
					c = next.c;
					direction = (direction+3)%4;	//그 방향으로 회전
					break;
				}
			}
			
			//방향 회전이 끝났을 때
			if(i==3)
			{
				direction = (direction+3)%4;	//바라보는 방향 원상태로	
				next = direction_point(r, c, ((direction+3)%4+3)%4);		//뒷방향 칸 찾기
				
				if(arr[next.r][next.c] == -1)	//벽이 아닌 경우 이동
				{
					r = next.r;
					c = next.c;
					continue;
				}
				else		//벽인경우 탈출
					break;
			}
		}
		
		System.out.print(count);
	}

	//방향별 가리키는 점
	static Point direction_point(int r, int c, int d)
	{
		Point result;
		
		if(d == 0)		//북쪽
			result = new Point(r-1, c);
		else if(d == 1)	//동쪽
			result = new Point(r, c+1);
		else if(d == 2)	//남쪽
			result = new Point(r+1, c);
		else//(d == 3)	서쪽 
			result = new Point(r, c-1);
		
		return result;
	}
	
	static void PrintArr(int arr[][], int n, int m)
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<m; j++)
				System.out.print(arr[i][j]+" ");
			System.out.println();
		}
		System.out.println();
	}
}

class Point{
	int r;
	int c;
	Point(){};
	Point(int x, int y)
	{
		this.r = x;
		this.c = y;
	}
}
