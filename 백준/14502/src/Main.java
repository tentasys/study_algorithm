import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int map[][];
	static int max = 0;
	static ArrayList<Point> zero_list = new ArrayList<Point>();		//������ ������ ���� ����Ʈ��
	static ArrayList<Combi> combination = new ArrayList<Combi>();	//������ ���� ����Ʈ
	static int test = 0;

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
			
		//�Է¹޴°�
		for(int i=0; i<N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0)
					zero_list.add(new Point(i, j));		//0�̸� ���� ���� �� �ִ�
			}
		}
		
		//���� ����Ʈ ���ϱ�
		Combination(0, 0, null);
		
		//���� ����Ʈ���� BFS ����
		for(Combi c : combination)
		{
			map[c.p1.r][c.p1.c] = 1;
			map[c.p2.r][c.p2.c] = 1;
			map[c.p3.r][c.p3.c] = 1;
			
			boolean visit[][] = new boolean[N][M];
			int temp_max = zero_list.size()-3;				//�� 3�� ����� �̸�ŭ�� ������
			Queue<Point> q = new LinkedList<Point>();		//BFS ť
			
			for(int i=0; i<N; i++)
			{
				for(int j=0; j<M; j++)
				{
					if(map[i][j] == 2 && visit[i][j] == false)		//���̷����� �ִ� ĭ�� ���� ���ҽ�Ű��
					{
						//BFS�� Ž���ϸ� 2�� �����ִ� �ִ�Ÿ��� ���ϱ�
						q.offer(new Point(i, j));
						while(!q.isEmpty())
						{
							Point temp = q.poll();
							if(visit[temp.r][temp.c] == true)	continue;
							
							visit[temp.r][temp.c] = true;	//�湮 ǥ��
							if(map[temp.r][temp.c] == 0)
								temp_max--;						//���� ����
							
							//2 ���ƴٴϱ�
							if(temp.r > 0)		//��
								if(map[temp.r-1][temp.c] != 1 && visit[temp.r-1][temp.c] == false)
									q.offer(new Point(temp.r-1, temp.c));
							if(temp.c > 0)		//��
								if(map[temp.r][temp.c-1] != 1 && visit[temp.r][temp.c-1] == false)
									q.offer(new Point(temp.r, temp.c-1));
							if(temp.r < N-1)	//��
								if(map[temp.r+1][temp.c] != 1 && visit[temp.r+1][temp.c] == false)
									q.offer(new Point(temp.r+1, temp.c));
							if(temp.c < M-1)	//��
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
		if(count == 3)		//3�� �� ����� ��
		{
			Point temp1 = new Point(zero_list.get(temp_list[0]).r, zero_list.get(temp_list[0]).c);
			Point temp2 = new Point(zero_list.get(temp_list[1]).r, zero_list.get(temp_list[1]).c);
			Point temp3 = new Point(zero_list.get(temp_list[2]).r, zero_list.get(temp_list[2]).c);
			
			Combi temp = new Combi(temp1, temp2, temp3);
			combination.add(temp);
			return;
		}
		if(count == 0)		//ó���� ��
			temp_list = new int[3];		//���տ��� �� �ε��� ����
		
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