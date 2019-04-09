import java.io.*;
import java.util.*;

//41�� 21��
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
				
				//ġŲ�� ����Ʈ�� �� ����Ʈ�� �߰�
				if(map[i][j]==1)		house.add(new Point(i, j));
				else if(map[i][j] == 2)	chicken.add(new Point(i, j));
			}
		}
		//�Է� �Ϸ�
		
		DFS(0, 0, null);
		
		System.out.println(min);
	}

	static void DFS(int idx, int count, int[] dist) {
		
		if(count == M)		//ġŲ�� �� ����� ��
		{
			int sum = 0;		
			for(int a : dist)
				sum += a;	
			min = Math.min(min, sum);
			return;
		}
		
		//����Լ� ���� ���� ��
		if(count == 0)
		{
			dist = new int[house.size()];			//���� ġŲ�� ������ �Ÿ��� ���� �迭
			Arrays.fill(dist, Integer.MAX_VALUE);	//�ʱ�ȭ
		}
		
		int temp[] = new int[house.size()];			//�Ÿ��� ������ ���� �ӽ÷� ������ �迭
		
		for(int i=idx; i<chicken.size(); i++)
		{
			System.arraycopy(dist, 0, temp, 0, dist.length);	//�ӽ÷� �迭�� ����
			
			//ġŲ������ �ּҰŸ� ���ϱ�
			for(int j=0; j<house.size(); j++)
				dist[j] = Math.min(dist[j], distance(house.get(j), chicken.get(i)));	//�������� �� ������ ����, �ƴϸ� �� �� �ֱ�

			DFS(i+1, count+1, dist);		//����Լ� ����
			
			System.arraycopy(temp, 0, dist, 0, dist.length);	//�ٽ� ���󺹱�
		}
	}
	
	static int distance(Point p1, Point p2)		//�������� �Ÿ����ϱ�
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
