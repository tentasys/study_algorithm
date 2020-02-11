import java.util.*;
import java.io.*;

//1�ð� 27��
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
		//-----------�Է� ��
		
		int count = 0;
		while(solution())		//�α��̵��� ����������
		{
			count++;
		}
		
		System.out.print(count);
	}

	static boolean solution()	//�α��̵� ����
	{
		boolean result = false;
		boolean visit[][] = new boolean[N][N];	//�湮 ���θ� ���� �迭
		int dr[] = {1, -1, 0, 0};
		int dc[] = {0, 0, 1, -1};
		int union[][] = new int[N][N];			//������ ���� � ���տ� �����ִ���. 0�� ���Ҽ�
		int member[] = new int[N*N+1];		//�� ���մ� ��ĭ�� �������. 1���� ����! 0�� ���Ҽ�!
		
		int union_no = 0;
		
		for(int i=0; i<N; i++)
		{
			for(int j=0; j<N; j++)
			{
				if(visit[i][j] == true)		continue;	//�湮�� ���� ���� �ʴ´�
				
				Queue<Point> q = new LinkedList<Point>();	//BFS ����
				q.offer(new Point(i, j));
				visit[i][j] = true;			//ť�� �ֱ����� �湮�ߴٰ� �ؾ��Ѵ�
				
				//���� �ϳ��� ť �Ѱ�
				int count = 1;
				int sum = map[i][j];
				union_no++;
				union[i][j] = union_no;
				
				while(!q.isEmpty())
				{
					Point cur = q.poll();
					
					for(int k=0; k<4; k++)		//�����¿� �̵�
					{
						int nR = dr[k] + cur.r;
						int nC = dc[k] + cur.c;
						
						if(nR < 0 || nR >= N || nC < 0 || nC >= N)		//���� ������ ������ �ƴϸ� �н�
							continue;
						if(diff(cur, nR, nC)<L || diff(cur, nR, nC)>R)	//L���̻� R�����ϰ� �ƴϸ� �н�
							continue;
						if(visit[nR][nC] == true)			//�̹� �湮�� ���� ���� �ʴ´�
							continue;
						
						//���� ������ ����
						result = true;
						visit[nR][nC] = true;		//�̵�
						q.offer(new Point(nR, nC));
						count++;
						sum += map[nR][nC];
						union[nR][nC] = union_no;
					}
				}//���� ��
				
				member[union_no] = sum/count;		//�� ������ �α� ��
			}//--ĭ���� üũ�ϴ� �ݺ���
		}
		
		//�α� ���� ������Ʈ
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

	static int diff(Point p, int r, int c)		//�� ���� �α���
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
